package fr.ece.tweetstats.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.beans.factory.annotation.Autowired;

import fr.ece.tweetstats.controller.ViewController;
import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.search.domain.Search;
import fr.ece.tweetstats.search.serviceapi.SearchService;
import fr.ece.tweetstats.core.domain.Tweet;

import fr.ece.tweetstats.view.MapView;

@org.springframework.stereotype.Component
public class MainView extends JFrame implements ActionListener, ListSelectionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JTextField addItemTextField;
	private JTextField addSubjectField;
    private JButton addItemButton;
    private JButton removeItemButton;
    private JButton fetchButton;
    private DefaultListModel itemList;
    private JList elementJList;
    private BarChart barChart;
    private LineChart lineChart;
    private JPanel barChartPanel;
    private JPanel lineChartPanel;
    private JPanel mapChartPanel;
    private JComboBox brandList;
    private JLabel dateFetchLabel;
    private JLabel totalLabel;
    private JLabel fromTwitterLabel;
    private JLabel fromMongoLabel;
    private Boolean bool;
    private String[] brand;
    private MapView mapView;
    
    @Autowired
    private ViewController controller;
    
    public MainView() {
        super("Tweetstats");
        bool = false;
        brand = new String[2];
        
        this.buildFrame();
        this.setVisible(true);
    }
    
    private void buildFrame() {    	
        //On donne une taille à notre fenetre
        this.setSize(1240,778);
        //On centre la fenêtre sur l'écran
        this.setLocationRelativeTo(null);
        //On interdit la redimensionnement de la fenêtre
        this.setResizable(false); 
        //On dit à l'application de se fermer lors du clic sur la croix
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //######################## MainPanel ########################
        JPanel mainViewPanel = new JPanel(new BorderLayout());
        mainViewPanel.setBackground(Color.WHITE);
        
        //######################## AsidePanel ########################
        JPanel asidePanel = new JPanel();
        asidePanel.setBackground(Color.WHITE);
        asidePanel.setLayout(new BoxLayout(asidePanel, BoxLayout.Y_AXIS));
        asidePanel.add(Box.createVerticalStrut(8));
        
        //######################## FlowFetchPanel ########################
        JPanel flowFetchPanel = new JPanel();
        flowFetchPanel.setLayout(new FlowLayout());
        Border fetchFrame = BorderFactory.createTitledBorder("Fetch");
        flowFetchPanel.setBorder(fetchFrame);
        this.setMySize(flowFetchPanel, 300, 180);
        flowFetchPanel.setBackground(Color.WHITE);
        
        //######################## FetchPanel ########################
        JPanel fetchPanel = new JPanel();
        fetchPanel.setLayout(new BoxLayout(fetchPanel, BoxLayout.Y_AXIS));
        fetchPanel.setBackground(Color.WHITE);
        
        fetchButton = new JButton("Fetch");
        fetchButton.setBackground(Color.WHITE);
        fetchButton.addActionListener(this);
        this.setMySize(fetchButton, 100, 40);
        fetchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        fetchPanel.add(fetchButton);
        
        fetchPanel.add(Box.createVerticalStrut(10));
        brandList = new JComboBox();
        brandList.addActionListener(this);
        fetchPanel.add(brandList);
        
        fetchPanel.add(Box.createVerticalStrut(10));
        addSubjectField = new JTextField();
        addSubjectField.addKeyListener(this);
        this.setMySize(addSubjectField, 200, 40);
        fetchPanel.add(addSubjectField);
        
        flowFetchPanel.add(fetchPanel);
        
        asidePanel.add(flowFetchPanel);
        
        //######################## FlowJListPanel ########################
        JPanel flowJListPanel = new JPanel();
        flowFetchPanel.setLayout(new FlowLayout());
        Border jListFrame = BorderFactory.createTitledBorder("Keywords");
        flowJListPanel.setBorder(jListFrame);
        this.setMySize(flowJListPanel, 300, 300);
        flowJListPanel.setBackground(Color.WHITE);
        
        //######################## JListPanel ########################
        JPanel JListPanel = new JPanel();
        JListPanel.setLayout(new BoxLayout(JListPanel, BoxLayout.Y_AXIS));
        JListPanel.setBackground(Color.WHITE);
        
        itemList = new DefaultListModel();
    	elementJList = new JList(itemList);
        elementJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        elementJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        elementJList.setSelectedIndex(0);
        elementJList.addListSelectionListener(this);

        JScrollPane listScroller = new JScrollPane(elementJList);
        listScroller.setPreferredSize(new Dimension(200, 250));
        JListPanel.add(listScroller);
        
        flowJListPanel.add(JListPanel);
        asidePanel.add(flowJListPanel);
        
        //######################## AddRemoveItemPanel ########################
        JPanel addRemoveItemsPanel = new JPanel();
        this.setMySize(addRemoveItemsPanel, 300, 100);
        addRemoveItemsPanel.setBackground(Color.WHITE);
        Border frame = BorderFactory.createTitledBorder("add/remove keywords");
        addRemoveItemsPanel.setBorder(frame);
        
        addRemoveItemsPanel.setLayout(new BoxLayout(addRemoveItemsPanel, BoxLayout.X_AXIS));
        addItemButton = new JButton("+");
        addItemButton.addActionListener(this);
        this.setMySize(addItemButton, 40, 40);
        
        removeItemButton = new JButton("-");
        removeItemButton.addActionListener(this);
        this.setMySize(removeItemButton, 40, 40);
        
        addRemoveItemsPanel.add(removeItemButton);
        addRemoveItemsPanel.add(addItemButton);
        
        addItemTextField = new JTextField();
        this.setMySize(addItemTextField, 200, 40);
        addRemoveItemsPanel.add(Box.createHorizontalStrut(10));
        addRemoveItemsPanel.add(addItemTextField);
        
        asidePanel.add(addRemoveItemsPanel);
        
        //######################## FlowInformationPanel ########################
        JPanel flowInformationPanel = new JPanel();
        flowInformationPanel.setLayout(new FlowLayout());
        Border informationFrame = BorderFactory.createTitledBorder("Fetch informations");
        flowInformationPanel.setBorder(informationFrame);
        flowInformationPanel.setBackground(Color.WHITE);
        
        //######################## InformationPanel ########################
        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        informationPanel.setBackground(Color.WHITE);
        
        informationPanel.add(Box.createVerticalStrut(10));
        totalLabel = new JLabel("Total: " + 0 + " tweets");
        informationPanel.add(totalLabel);
        
        informationPanel.add(Box.createHorizontalStrut(10));
        fromTwitterLabel = new JLabel("From Twitter: " + 0 + " tweets");
        informationPanel.add(fromTwitterLabel);
        
        informationPanel.add(Box.createHorizontalStrut(10));
        fromMongoLabel = new JLabel("From MongoDB: " + 0 + " tweets");
        informationPanel.add(fromMongoLabel);
        
        informationPanel.add(Box.createVerticalStrut(10));
        dateFetchLabel = new JLabel("Date: 00/00/00");
        informationPanel.add(dateFetchLabel);
        
        flowInformationPanel.add(informationPanel);
        
        asidePanel.add(flowInformationPanel);
        asidePanel.add(Box.createVerticalStrut(8));
        
        mainViewPanel.add(asidePanel, BorderLayout.WEST);
        
        //######################## GraphPanels ########################
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
        
        //######################## BarChartPanel ########################
        barChartPanel = new JPanel(new FlowLayout());
        barChartPanel.setBackground(Color.WHITE);
        
        tabbedPane.addTab("Bar Chart", barChartPanel);
        
        //######################## LineChartPanel ########################
        lineChartPanel = new JPanel(new FlowLayout());
        lineChartPanel.setBackground(Color.WHITE);
        
        tabbedPane.addTab("Line Chart", lineChartPanel);
        
      //######################## MapChartPanel ########################
        mapView = new MapView();
        mapChartPanel = new JPanel(new FlowLayout());
        mapChartPanel.add(mapView);
        mapChartPanel.setBackground(Color.WHITE);
        
        tabbedPane.addTab("Map Chart", mapChartPanel);
        
        mainViewPanel.add(tabbedPane, BorderLayout.CENTER);
        this.setContentPane(mainViewPanel);
    }
    
    private void setMySize(JComponent component, int x, int y) {
        component.setMinimumSize(new Dimension(x,y));
        component.setMaximumSize(new Dimension(x,y));
        component.setPreferredSize(new Dimension(x,y));
    }
    
    private void setPresetForBrand(String brand) {
		itemList.removeAllElements();
    	if(controller.getSearchByBrand(brand) != null) {
	    	Search search = controller.getSearchByBrand(brand);
	    	for(int i = 0; i < search.getAdjectives().size(); i++) {
	    		itemList.addElement(search.getAdjectives().get(i));
	    	}
    	}
    }

	public void populateComboBox() {
		List<Search> searches = controller.getAllSearches();
		
		for(int i = 0; i < searches.size(); i++) {
			brandList.addItem(searches.get(i).getBrand());
		}	
		
		this.setPresetForBrand((String)brandList.getItemAt(0));
	}
	
	private void savePreset() {
		//save search
    	Search search = controller.getSearchByBrand(brandList.getSelectedItem().toString());
		List<String> adjList = new ArrayList<String>();
		for(int i = 0; i < itemList.size(); i++) {
			adjList.add(itemList.getElementAt(i).toString());
		}

		search.setAdjectives(adjList);
		controller.saveSearch(search);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
    	Object source;
         
        if(e.getSource() instanceof JButton) {
        	source = (JButton)(e.getSource());
	        if(source == addItemButton) {
                int count = 0;
                int loopVar = 0; 
	            while(loopVar < itemList.size()) {
	                if(addItemTextField.getText().equals(itemList.get(loopVar).toString())) {
	                    count++;
	                }
	                loopVar++;
	            }
	            if(count == 0 && !addItemTextField.getText().equals("")) {
	                itemList.addElement(addItemTextField.getText());
	            	this.savePreset();
	            }
	            addItemTextField.setText("");
	        }
	        else if(source == removeItemButton) {
	            if(elementJList.getSelectedIndices().length > 0) {
	                int[] selectedIndices = elementJList.getSelectedIndices();
	                for (int i = selectedIndices.length-1; i >=0; i--) {
	                    itemList.removeElementAt(selectedIndices[i]);
	                } 
	                this.savePreset();
	            } 
	        }
	        else if(source == fetchButton) {
	        	if(itemList.size() > 0) {
		        	List<String> arrayAdj = new ArrayList<String>();
		        	for(int i = 0; i < itemList.size(); i++) {
		        		arrayAdj.add(itemList.get(i).toString());
		        	}
		        	
		        	List<Fetch> fetches = controller.doFetchAndSave(brandList.getSelectedItem().toString(), arrayAdj);
		        	// update charts
                    barChart = new BarChart(fetches);
		            barChartPanel.removeAll();
		            barChartPanel.add(barChart.getChartPanel());
		            barChartPanel.validate();
		            barChartPanel.repaint();
		            
		            lineChart = new LineChart(fetches);
		            lineChartPanel.removeAll();
		            lineChartPanel.add(lineChart.getChartPanel());
		            lineChartPanel.validate();
		            lineChartPanel.repaint();
		            
		           // update informations
		           Calendar today = Calendar.getInstance();
		           today.set(Calendar.HOUR_OF_DAY, 0);
		           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		           String formattedDate = sdf.format(today.getTime());
		    	   dateFetchLabel.setText("Date: " + formattedDate);
		
		    	   int total = 0;
		    	   int fromTwitter = 0;
		    	   for(Fetch fetch : fetches) {
                       total += fetch.getResults().size();
                       if (fetch.getFetchedFromTwitter() != null) {
                           fromTwitter += fetch.getFetchedFromTwitter();
                           fetch.setFetchedFromTwitter(0);
                           controller.saveFetch(fetch);
                       }
                       // update map chart
                       mapView.performJS("clear();");
                       for (Tweet tweet : fetch.getResults()) {
                           if (tweet.getLocation() != null) {
                               mapView.performJS("newMarker(" + tweet.getLocation() + ");");
                           }
                       }
                   }
                   totalLabel.setText("Total: " + total + " tweets");
                   fromTwitterLabel.setText("From Twitter: " + fromTwitter + " tweets");
                   fromMongoLabel.setText("From MongoDB: " + (total - fromTwitter) + " tweets");
		        }
	        }
        }
        else if(e.getSource() instanceof JComboBox) {
        	source = (JComboBox)(e.getSource());
        	if(source == brandList) {
        		brand[1] = brandList.getSelectedItem().toString();
        		
        		if(!bool) {
        			brand[0] = brandList.getSelectedItem().toString();
        			bool = true;
        		}
        		
        		if(brand[0] != brand[1] && bool) {
        			this.setPresetForBrand(brandList.getSelectedItem().toString());
        			brand[0]=brand[1];
        		}
        	}
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

	@Override
	public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        	if(addSubjectField.getText() != "") {
        		brandList.addItem(addSubjectField.getText());
        		addSubjectField.setText("");
        		brandList.getModel().setSelectedItem(brandList.getItemAt(brandList.getItemCount() - 1));
        		Search search = new Search();
        		search.setBrand((String)brandList.getItemAt(brandList.getItemCount() - 1));
        		controller.saveSearch(search);
        	}
        }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
