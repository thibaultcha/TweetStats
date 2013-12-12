package fr.ece.tweetstats.main;

import java.util.Arrays;
import java.util.List;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.twitterapi.TwitterAPI;

public class Main {

	public static void main(String[] args) {
		TwitterAPI.getByBrandAndAdjective("RATP", "grève");

		List<String> adjectives = Arrays.asList("grève", "retard");
		// Synchrone call to Twitter API
		List<Fetch> fetchResults = TwitterAPI.getByBrandAndAdjectives("RATP", adjectives);
		
		for (Fetch fetch : fetchResults) {
			for (Tweet tweet : fetch.getResults()) {
				System.out.println(tweet.getMessage());
			}
		}
	}

}
