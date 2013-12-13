package fr.ece.tweetstats.twitterapi;

import java.util.Comparator;

import fr.ece.tweetstats.core.domain.Tweet;

public class TweetComparator implements Comparator<Tweet> {

	@Override
	public int compare(Tweet b1, Tweet b2) {
		if (b1.getId().longValue()>b2.getId().longValue()){
		     return 1;	 
		   }
		   else if (b1.getId().longValue()<b2.getId().longValue()){
			   return -1;
		   }else{
			   return 0; 
		   }
	}

	/**
	 * 	if (b1.getDate().after(b2.getDate())) {
					return 1;
				} else if (b1.getDate().before(b2.getDate())) {
					return -1;
				} else {
					return 0;
				}
	 */
}