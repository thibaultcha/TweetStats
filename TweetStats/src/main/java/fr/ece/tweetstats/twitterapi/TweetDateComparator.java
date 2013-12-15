package fr.ece.tweetstats.twitterapi;

import java.util.Comparator;

import fr.ece.tweetstats.core.domain.Tweet;

public class TweetDateComparator implements Comparator<Tweet> {

	@Override
	public int compare(Tweet arg0, Tweet arg1) {

		if (arg0.getDate().isAfter(arg1.getDate())) {
			return 1;
		} else if (arg0.getDate().isBefore(arg1.getDate())) {
			return -1;
		} else {
			return 0;
		}	}

}
