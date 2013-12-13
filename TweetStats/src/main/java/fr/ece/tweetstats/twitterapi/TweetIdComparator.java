package fr.ece.tweetstats.twitterapi;

import java.util.Comparator;

import fr.ece.tweetstats.core.domain.Tweet;

public class TweetIdComparator implements Comparator<Tweet> {

	@Override
	public int compare(Tweet arg0, Tweet arg1) {
		// TODO Auto-generated method stub
		if (arg0.getDate().after(arg1.getDate())) {
			return 1;
		} else if (arg0.getDate().before(arg1.getDate())) {
			return -1;
		} else {
			return 0;
		}
	}

}
