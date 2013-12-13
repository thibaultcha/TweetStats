package fr.ece.tweetstats.twitterapi;

import java.util.Comparator;

import fr.ece.tweetstats.core.domain.Tweet;

public class TweetIdComparator implements Comparator<Tweet> {

	@Override
	public int compare(Tweet b1, Tweet b2) {
		// TODO Auto-generated method stub
		if (b1.getTweetId().longValue()>b2.getTweetId().longValue()){
		     return 1;	 
		   }
		   else if (b1.getTweetId().longValue()<b2.getTweetId().longValue()){
			   return -1;
		   }else{
			   return 0; 
		   }
	}

}
