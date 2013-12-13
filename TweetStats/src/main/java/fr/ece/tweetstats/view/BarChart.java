/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.tweetstats.view;

import java.awt.Dimension;
import javax.swing.DefaultListModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BarChart extends ApplicationFrame {
    private final ChartPanel chartPanel;
    public BarChart(DefaultListModel itemList) {
        super("Tweetstats");

        final CategoryDataset dataset = updateDataset(itemList);
        final JFreeChart chart = createChart(dataset);
        chart.setTitle("Tweetstats");
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(950, 800));
    }

    private CategoryDataset updateDataset(DefaultListModel itemList) {
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // column keys...
        for(int i = 0; i < itemList.size(); i++) {
            dataset.addValue(10, "first", itemList.get(i).toString());
        }
        
        return dataset;
    }
    
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Bar Chart Demo",         // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        
        return chart;
    }
    
    public ChartPanel getChartPanel() {
        return chartPanel;
    }
}


