package fr.ece.tweetstats.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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

import fr.ece.tweetstats.view.BarChart;
import fr.ece.tweetstats.view.LineChart;

@org.springframework.stereotype.Component
public class MainView extends JFrame implements ActionListener, ListSelectionListener {
    private JTextField addItemTextField;
    private JButton addItemButton;
    private JButton removeItemButton;
    private JButton fetchButton;
    private DefaultListModel itemList;
    private JList elementJList;
    private int count;
    private int loopVar;
    private BarChart barChart;
    private LineChart lineChart;
    private JPanel barChartPanel;
    private JPanel lineChartPanel;
    
    public MainView() {
        super("Tweetstats");
        
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
        Border fetchFrame = BorderFactory.createTitledBorder("Fetch area");
        flowFetchPanel.setBorder(fetchFrame);
        this.setMySize(flowFetchPanel, 300, 90);
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
        flowFetchPanel.add(fetchPanel);
        
        asidePanel.add(flowFetchPanel);
        
        //######################## FlowJListPanel ########################
        JPanel flowJListPanel = new JPanel();
        flowFetchPanel.setLayout(new FlowLayout());
        Border jListFrame = BorderFactory.createTitledBorder("Items area");
        flowJListPanel.setBorder(jListFrame);
        this.setMySize(flowJListPanel, 300, 300);
        flowJListPanel.setBackground(Color.WHITE);
        
        //######################## JListPanel ########################
        JPanel JListPanel = new JPanel();
        JListPanel.setLayout(new BoxLayout(JListPanel, BoxLayout.Y_AXIS));
        JListPanel.setBackground(Color.WHITE);
        
        itemList = new DefaultListModel();

        itemList.addElement("putain");
        itemList.addElement("fuck");
        itemList.addElement("insupportable");
        itemList.addElement("intolérable");
        itemList.addElement("énervant");
        itemList.addElement("merde");
        
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
        Border frame = BorderFactory.createTitledBorder("add/Remove");
        addRemoveItemsPanel.setBorder(frame);
        
        addRemoveItemsPanel.setLayout(new BoxLayout(addRemoveItemsPanel, BoxLayout.X_AXIS));
        //buttonPanel.setBackground(Color.WHITE);
        addItemButton = new JButton("+");
        addItemButton.addActionListener(this);
        addItemButton.setPreferredSize(new Dimension(40,40));
        removeItemButton = new JButton("-");
        removeItemButton.addActionListener(this);
        removeItemButton.setPreferredSize(new Dimension(40,40));
        
        addRemoveItemsPanel.add(removeItemButton);
        addRemoveItemsPanel.add(addItemButton);
        
        addItemTextField = new JTextField();
        //on lui donne une dimension
        this.setMySize(addItemTextField, 200, 40);
        //on peut rentrer jusqu'a 15 caracteres
        addItemTextField.setColumns(15);
        //on ajoute les differents elements
        addRemoveItemsPanel.add(Box.createHorizontalStrut(10));
        addRemoveItemsPanel.add(addItemTextField);
        
        asidePanel.add(addRemoveItemsPanel);
        
        //######################## InformationPanel ########################
        JPanel informationPanel = new JPanel();
        informationPanel.setBackground(Color.WHITE);
        Border informationFrame = BorderFactory.createTitledBorder("information");
        informationPanel.setBorder(informationFrame);
        
        JLabel label = new JLabel("hello");
        informationPanel.add(label);
        
        asidePanel.add(informationPanel);
        asidePanel.add(Box.createVerticalStrut(8));
        
        mainViewPanel.add(asidePanel, BorderLayout.WEST);
        
        //######################## GraphPanels ########################
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
        
        //######################## BarChartPanel ########################
        barChartPanel = new JPanel(new FlowLayout());
        barChart = new BarChart(itemList);
        barChartPanel.add(barChart.getChartPanel());
        barChartPanel.setBackground(Color.WHITE);
        
        tabbedPane.addTab("Bar Chart", barChartPanel);
        
        //######################## LineChartPanel ########################
        lineChartPanel = new JPanel(new FlowLayout());
        lineChart = new LineChart(itemList);
        lineChartPanel.add(lineChart.getChartPanel());
        lineChartPanel.setBackground(Color.WHITE);
        
        tabbedPane.addTab("Line Chart", lineChartPanel);

        mainViewPanel.add(tabbedPane, BorderLayout.CENTER);
        this.setContentPane(mainViewPanel);
    }
    
    private void setMySize(JComponent component, int x, int y) {
        component.setMinimumSize(new Dimension(x,y));
        component.setMaximumSize(new Dimension(x,y));
        component.setPreferredSize(new Dimension(x,y));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //on recupere la source du clic
        Object source = (JButton)(e.getSource());
        
        count = 0;
        loopVar = 0;
        
        if(source == addItemButton) {
            while(loopVar < itemList.size()) {
                if(addItemTextField.getText().equals(itemList.get(loopVar).toString())) {
                    System.out.println(itemList.get(loopVar).toString());
                    count++;
                }
                loopVar++;
            }
            if(count == 0 && !addItemTextField.getText().equals(""))
                itemList.addElement(addItemTextField.getText());
            addItemTextField.setText("");
        }
        else if(source == removeItemButton) {
            if(elementJList.getSelectedIndices().length > 0) {
                int[] selectedIndices = elementJList.getSelectedIndices();
                for (int i = selectedIndices.length-1; i >=0; i--) {
                    itemList.removeElementAt(selectedIndices[i]);
                } 
            } 
        }
        else if(source == fetchButton) {
            barChart = new BarChart(itemList);
            barChartPanel.removeAll();
            barChartPanel.add(barChart.getChartPanel());
            barChartPanel.validate();
            barChartPanel.repaint();
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
    }
}
