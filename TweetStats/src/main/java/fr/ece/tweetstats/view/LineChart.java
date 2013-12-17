package fr.ece.tweetstats.view;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
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
        
        XYPlot plot = (XYPlot) chart.getPlot();
        DateAxis range = new DateAxis("Date");
        range.setDateFormatOverride(new SimpleDateFormat("dd/MM/yyyy"));
        plot.setDomainAxis(range);
        
        chart.getXYPlot().setRenderer(new XYSplineRenderer());
        
        chart.setBackgroundPaint(Color.WHITE);
        lineChartPanel = new ChartPanel(chart);
        lineChartPanel.setPreferredSize(new Dimension(930, 700));
    }
    
    private XYDataset updateDataset(List<Fetch> fetches) {
    	final TimeSeriesCollection dataset = new TimeSeriesCollection();
    	
    	for(Fetch fetch : fetches) {
    		final TimeSeries series = new TimeSeries(fetch.getAdjective(), Day.class);
    		TreeMap<LocalDate, ArrayList<Tweet>> grouped = groupByDate(fetch);
    		
    		for (Entry<LocalDate, ArrayList<Tweet>> entry : grouped.entrySet()) {
    			Date date = entry.getKey().toDate();
    	        series.add(new Day(date), entry.getValue().size());
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
