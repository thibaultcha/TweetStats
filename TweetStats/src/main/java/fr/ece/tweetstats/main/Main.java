package fr.ece.tweetstats.main;

import java.util.Arrays;
import java.util.List;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.core.serviceapi.FetchService;
import fr.ece.tweetstats.twitterapi.TwitterAPI;

public class Main {

	private FetchService fetchService;
	
	public static void main(String[] args) {
		TwitterAPI.getByBrandAndAdjective("RATP", "grève");

		List<String> adjectives = Arrays.asList("grève", "retard");
		// Synchrone call to Twitter API
		List<Fetch> fetchResults = TwitterAPI.getByBrandAndAdjectives("RATP", adjectives);
		for (Fetch fetch : fetchResults) {
			System.out.println("--- " + fetch.getAdjective() + " ---");
			for (Tweet tweet : fetch.getResults()) {
				System.out.println(tweet.getTweetId() + "\t" + tweet.getMessage());
			}
		}
		
		List<Tweet> tweetResults = TwitterAPI.getByBrandAndAdjective(fetchResults.get(0).getBrand(), 
																	 fetchResults.get(0).getAdjective(), 
																	 fetchResults.get(0).getLastId());
		System.out.println("--- "+ fetchResults.get(0).getAdjective() + " lastId: " + fetchResults.get(0).getLastId() + " ---");
		for (Tweet tweet : tweetResults) {
			System.out.println(tweet.getTweetId() + "\t" + tweet.getMessage());
		}
	}

}
