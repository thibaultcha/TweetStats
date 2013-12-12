package fr.ece.tweetstats.twitterapi;

import java.util.List;

import fr.ece.tweetstats.core.domain.Tweet;
import twitter4j.*;
import twitter4j.auth.AccessToken;

public class TwitterAPI {

	public static List<Tweet> get(){
		Twitter twitter=new TwitterFactory().getInstance();
		twitter.setOAuthConsumer("g43gQM0aonUSCILzb84xQ", "dpeXTuKau8CpmcDzC1J1FL90VbGuV75GVuHWOBsuAY");
		twitter.setOAuthAccessToken(loadAccessToken());

		try {
			Query query=new Query("Test");
			QueryResult result;
			do {
				result=twitter.search(query);
				List<Status> tweets=result.getTweets();
				for (Status tweet : tweets){
					System.out.println(tweet.getUser().getScreenName() + ": " + tweet.getText());
					
				}
			} while ((query = result.nextQuery()) != null);
			
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static AccessToken loadAccessToken() {
	    String token = "2242385018-Edtcq4Ej5acALsCfehGkBHPO6naNR0dDSr0Kvpe";
	    String tokenSecret = "9Ayq225X0yTnupFAznOrgZR8svVve6cdWjQ93EcHghxtX";
	    return new AccessToken(token, tokenSecret);
	}
}
