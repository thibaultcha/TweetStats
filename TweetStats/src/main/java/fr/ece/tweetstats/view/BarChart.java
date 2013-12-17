/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.tweetstats.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import fr.ece.tweetstats.core.domain.Fetch;

public class BarChart {
    private final ChartPanel barChartPanel;
    
    public BarChart(List<Fetch> fetches) {
    	final CategoryDataset dataset = updateDataset(fetches);
    	
    	final JFreeChart chart = ChartFactory.createBarChart(
    			fetches.get(0).getBrand(),         // chart title
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
    
    private CategoryDataset updateDataset(List<Fetch> fetches) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(int i = 0; i < fetches.size(); i++) {
            dataset.addValue(fetches.get(i).getResults().size(), "Words", fetches.get(i).getAdjective());
        }
        
        return dataset;
    }
    
    public ChartPanel getChartPanel() {
        return barChartPanel;
    }
}


