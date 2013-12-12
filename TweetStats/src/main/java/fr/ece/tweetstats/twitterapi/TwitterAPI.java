package fr.ece.tweetstats.twitterapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import twitter4j.*;
import twitter4j.auth.AccessToken;

public class TwitterAPI {

	public static final String Consumer_key = "g43gQM0aonUSCILzb84xQ";
	public static final String Consumer_secret = "dpeXTuKau8CpmcDzC1J1FL90VbGuV75GVuHWOBsuAY";
	public static final String Access_token = "2242385018-Edtcq4Ej5acALsCfehGkBHPO6naNR0dDSr0Kvpe";
	public static final String Access_token_secret = "9Ayq225X0yTnupFAznOrgZR8svVve6cdWjQ93EcHghxtX";

	public static Fetch getByBrandAndAdjective(String brand, String adj) {

		Fetch fetch = new Fetch();

		try {

			fetch.setAdjective(adj);
			fetch.setDate(new Date());
			fetch.setCreatedDate(new Date());
			fetch.setBrand(brand);
			Twitter twitter = getTwitter();

			Query query = new Query(fetch.getBrand() + " "
					+ fetch.getAdjective());
			QueryResult result;
			do {

				result = twitter.search(query);
				List<Status> tweets = result.getTweets();

				for (Status tweet : tweets) {
					Tweet tw = new Tweet(tweet.getId(), tweet.getCreatedAt(),
							tweet.getText());
					fetch.addResult(tw);
				}
			} while ((query = result.nextQuery()) != null);

		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return fetch;
	}

	public static List<Fetch> getByBrandAndAdjectives(String brand, List<String> adjs) {
		List<Fetch> fetchs = new ArrayList<Fetch>();

		for (int i = 0; i < adjs.size(); i++) {
			Fetch f = getByBrandAndAdjective(brand, adjs.get(i));
			fetchs.add(f);
		}
		return fetchs;
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
