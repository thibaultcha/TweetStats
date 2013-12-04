package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Tweet;
import java.util.Date;

/**
 * Builder for Tweet class.
 */
public class TweetBuilder {

	private Long tweetId;
	private Date date;
	private String message;

	/**
	 * Static factory method for TweetBuilder
	 */
	public static TweetBuilder tweet() {
		return new TweetBuilder();
	}

	public TweetBuilder() {
	}

	public TweetBuilder(Long tweetId, Date date, String message) {

		this.tweetId = tweetId;

		this.date = date;

		this.message = message;

	}

	public TweetBuilder tweetId(Long val) {
		this.tweetId = val;
		return this;
	}

	public TweetBuilder date(Date val) {
		this.date = val;
		return this;
	}

	public TweetBuilder message(String val) {
		this.message = val;
		return this;
	}

	public Long getTweetId() {
		return tweetId;
	};

	public Date getDate() {
		return date;
	};

	public String getMessage() {
		return message;
	};

	/**
	 * @return new Tweet instance constructed based on the values that have been set into this builder
	 */
	public Tweet build() {
		Tweet obj = new Tweet(getTweetId(), getDate(), getMessage());

		return obj;
	}
}
