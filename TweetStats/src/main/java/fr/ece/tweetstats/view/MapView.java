package fr.ece.tweetstats.view;

import java.awt.BorderLayout;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.swing.JPanel;

import com.sun.javafx.application.PlatformImpl;

/**
 * SwingFXWebView
 */
public class MapView extends JPanel {
	private static final long serialVersionUID = 1L;
	private Stage stage;
	private WebView browser;
	private JFXPanel jfxPanel;
	private WebEngine webEngine;

	public MapView() {
		jfxPanel = new JFXPanel();
	    createScene();
		setLayout(new BorderLayout());
		add(jfxPanel, BorderLayout.CENTER);
	}

	private void createScene() {
		PlatformImpl.startup(new Runnable() {
			@Override
			public void run() {
				stage = new Stage();
				Group root = new Group();
				Scene scene = new Scene(root, 900, 1100);
				stage.setScene(scene);
				// Set up the embedded browser:
				browser = new WebView();
				webEngine = browser.getEngine();
				webEngine.load(getClass().getResource("/index.html").toString());
				ObservableList<Node> children = root.getChildren();
				children.add(browser);
				jfxPanel.setScene(scene);
			}
		});
	}
	
	public void performJS(final String js) {
		Platform.runLater(new Runnable() { 
            @Override
            public void run() {
            	webEngine.executeScript(js);
            }
        });
	}
	
}