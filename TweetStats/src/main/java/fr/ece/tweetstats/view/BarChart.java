/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.tweetstats.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {
    private final ChartPanel barChartPanel;
    
    public BarChart(DefaultListModel itemList) {
        final CategoryDataset dataset = updateDataset(itemList);

        final JFreeChart chart = ChartFactory.createBarChart(
            "Tweetstats",         // chart title
            "Words",               // domain axis label
            "Number",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );
        chart.setBackgroundPaint(Color.WHITE);
        barChartPanel = new ChartPanel(chart);
        barChartPanel.setPreferredSize(new Dimension(930, 700));
    }

    private CategoryDataset updateDataset(DefaultListModel itemList) {
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // column keys...
        for(int i = 0; i < itemList.size(); i++) {
            dataset.addValue(10, "Words", itemList.get(i).toString());
        }
        
        return dataset;
    }
    
    public ChartPanel getChartPanel() {
        return barChartPanel;
    }
}


