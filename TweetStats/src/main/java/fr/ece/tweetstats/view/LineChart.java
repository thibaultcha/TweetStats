package fr.ece.tweetstats.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.joda.time.LocalDate;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;

public class LineChart {
	private final ChartPanel lineChartPanel;
    
    public LineChart(List<Fetch> fetches) {
        final XYDataset dataset = updateDataset(fetches);

        final JFreeChart chart = ChartFactory.createXYLineChart(
        	fetches.get(0).getBrand(),         // chart title
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
    
    private XYDataset updateDataset(List<Fetch> fetches) {
    	int count = 0;
    	final XYSeriesCollection dataset = new XYSeriesCollection();
    	
    	for(Fetch fetch : fetches) {
    		final XYSeries series = new XYSeries(fetch.getAdjective());
    		TreeMap<LocalDate, ArrayList<Tweet>> grouped = groupByDate(fetch);
    		
    		for (Entry<LocalDate, ArrayList<Tweet>> entry : grouped.entrySet()) {
    			series.add(count,entry.getValue().size());
    			count+=100;
    		}
    	
    		dataset.addSeries(series);
    	}
  
        return dataset;
    }
    
    public TreeMap<LocalDate, ArrayList<Tweet>> groupByDate (Fetch fetch) {
      	TreeMap<LocalDate, ArrayList<Tweet>> groupedByDate = new TreeMap<LocalDate, ArrayList<Tweet>>();
      	
  		for (Tweet tweet : fetch.getResults()) {
  			if (groupedByDate.get(tweet.getDate()) == null) {
  				groupedByDate.put(tweet.getDate(), new ArrayList<Tweet>(Arrays.asList(tweet)));
  			} else {
  				ArrayList<Tweet> mapArray = groupedByDate.get(tweet.getDate());
  				mapArray.add(tweet);
  				groupedByDate.put(tweet.getDate(), mapArray);
  			}
  		}
      	
      	
      	return groupedByDate;
  	}

    
    public ChartPanel getChartPanel() {
        return lineChartPanel;
    }
}
