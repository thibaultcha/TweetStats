package fr.ece.tweetstats.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChart {
	private final ChartPanel lineChartPanel;
    
    public LineChart(DefaultListModel itemList) {
        final XYDataset dataset = updateDataset(itemList);

        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Tweetstats",         // chart title
            "Time",               // domain axis label
            "Number",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );
        chart.setBackgroundPaint(Color.WHITE);
        lineChartPanel = new ChartPanel(chart);
        lineChartPanel.setPreferredSize(new Dimension(930, 700));
    }

    private XYDataset updateDataset(DefaultListModel itemList) {
    	final XYSeriesCollection dataset = new XYSeriesCollection();
    	
    	for(int i = 0; i < itemList.size(); i++) {
	        final XYSeries series = new XYSeries(itemList.get(i).toString());
	        series.add(1.0, 5.0);
	        series.add(2.0, 7.0);
	        series.add(3.0, 6.0);
	        series.add(4.0, 8.0);
	        series.add(5.0, 4.0);
	        series.add(6.0, 4.0);
	        series.add(7.0, 2.0);
	        series.add(8.0, 1.0);
	        
	        dataset.addSeries(series);
    	}

        return dataset;
    }
    
    public ChartPanel getChartPanel() {
        return lineChartPanel;
    }
}
