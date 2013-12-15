package fr.ece.tweetstats.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingUtilities;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.core.serviceapi.FetchService;
import fr.ece.tweetstats.twitterapi.TweetDateComparator;
import fr.ece.tweetstats.twitterapi.TweetIdComparator;
import fr.ece.tweetstats.twitterapi.TwitterAPI;

public class Main {

	public static void main(String[] args) {
		 /*
		 SwingUtilities.invokeLater(new Runnable() {
		 	@Override public void run() { MainView mainView = new MainView(); }
		 });
		 */
		 
		int count = 0;
		List<String> adjectives = Arrays.asList("grève", "retard");
		// Synchrone call to Twitter API
		List<Fetch> fetchResults = TwitterAPI.getByBrandAndAdjectives("RATP",
				adjectives);
		for (Fetch fetch : fetchResults) {
			System.out.println("--- " + fetch.getAdjective() + " ---");
			count += fetch.getResults().size();
			for (Tweet tweet : fetch.getResults()) {
				System.out.println(tweet.getTweetId() + "\t" + tweet.getMessage().replace("\n", " "));
			}
		}

		System.out.println("Total fetched tweets: " + count);

		
		/* LAST ID + SORT */
		/*
		List<Tweet> tweetResults = TwitterAPI.getByBrandAndAdjective(
				fetchResults.get(0).getBrand(), fetchResults.get(0)
						.getAdjective(), fetchResults.get(0).getLastId());
		
		System.out.println("--- " + fetchResults.get(0).getAdjective()
				+ " lastId: " + fetchResults.get(0).getLastId() + " ---");
		for (Tweet tweet : tweetResults) {
			System.out.println(tweet.getTweetId() + "\t" + tweet.getMessage().replace("\n", " "));
		}*/
		
		
		/* MONGODB */
		
	}

}
