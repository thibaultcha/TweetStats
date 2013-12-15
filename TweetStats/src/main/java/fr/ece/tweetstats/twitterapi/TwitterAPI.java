package fr.ece.tweetstats.twitterapi;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import twitter4j.*;
import twitter4j.auth.AccessToken;

public class TwitterAPI {

	public static final String Consumer_key = "g43gQM0aonUSCILzb84xQ";
	public static final String Consumer_secret = "dpeXTuKau8CpmcDzC1J1FL90VbGuV75GVuHWOBsuAY";
	public static final String Access_token = "2242385018-Edtcq4Ej5acALsCfehGkBHPO6naNR0dDSr0Kvpe";
	public static final String Access_token_secret = "9Ayq225X0yTnupFAznOrgZR8svVve6cdWjQ93EcHghxtX";

	/**
	 * Get a list of Tweet
	 * 
	 * @param brand
	 * @param adj
	 * @return List<Tweet>
	 */
	public static List<Tweet> getByBrandAndAdjective(String brand, String adj) {
		return getByBrandAndAdjective(brand, adj, null);
	}

	/**
	 * Get a list of Tweet from lastId
	 * 
	 * @param brand
	 * @param adj
	 * @param lastId
	 * @return
	 */
	public static List<Tweet> getByBrandAndAdjective(String brand, String adj, Long lastId) {
		ArrayList<Tweet> tweetResults = new ArrayList<Tweet>();	
		
		try {
			Query query = new Query(brand + " " + adj);
			query.resultType("recent");
			query.setCount(100);
			
			if (lastId != null) {
				query.sinceId(lastId); 
			}
			
			Twitter twitter = getTwitter();
			QueryResult result;
			do {
				result = twitter.search(query);
				for (Status status : result.getTweets()) {
					tweetResults.add(new Tweet(new Long(status.getId()), 
											   new LocalDate(status.getCreatedAt().getTime()),
											   status.getText(),
											   "place"));
				}
			} while ((query = result.nextQuery()) != null);

		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		// TODO Sort tweets by date

		return tweetResults;
	}
	
	/**
	 * Get a list of fetches with results if you don't have an already existing
	 * fetch
	 * 
	 * @param brand
	 * @param adjs
	 * @return List<Fetch>
	 */
	public static List<Fetch> getByBrandAndAdjectives(String brand,
			List<String> adjs) {
		List<Fetch> fetches = new ArrayList<Fetch>();

		for (int i = 0; i < adjs.size(); i++) {
			// create list of results
			List<Tweet> tweets = getByBrandAndAdjective(brand, adjs.get(i));

			// create new fetch
			Fetch fetch = new Fetch();
			fetch.setAdjective(adjs.get(i));
			fetch.setBrand(brand);
			fetch.setLastFetchDate(new LocalDate());
			for (Tweet tweet : tweets) {
				fetch.addResult(tweet);
			}
			fetch.setLastId(tweets.get(tweets.size()-1).getTweetId());

			// add to our return array
			fetches.add(fetch);
		}
		return fetches;
	}

	/**
	 * Update a Fetch with the new results from lastId
	 * 
	 * @param fetch
	 * @return
	 */
	public static Fetch getFromExistingFetch(Fetch fetch) {
		// retrieve the new tweets since fetch.lastId
		List<Tweet> newTweets = getByBrandAndAdjective(fetch.getBrand(),
				fetch.getAdjective(), fetch.getLastId());

		// add those new tweets to the existing Fetch object
		for (Tweet tweet : newTweets) {
			fetch.addResult(tweet);
		}

		return fetch;
	}

	private static Twitter getTwitter() {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Consumer_key, Consumer_secret);
		twitter.setOAuthAccessToken(loadAccessToken());
		return twitter;
	}

	private static AccessToken loadAccessToken() {
		String token = Access_token;
		String tokenSecret = Access_token_secret;
		return new AccessToken(token, tokenSecret);
	}
}
