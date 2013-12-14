package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Tweet;
import org.joda.time.LocalDate;

/**
 * Builder for Tweet class.
 */
public class TweetBuilder {

	private Long tweetId;
	private LocalDate date;
	private String message;
	private String location;

	/**
	 * Static factory method for TweetBuilder
	 */
	public static TweetBuilder tweet() {
		return new TweetBuilder();
	}

	public TweetBuilder() {
	}

	public TweetBuilder(Long tweetId, LocalDate date, String message, String location) {

		this.tweetId = tweetId;

		this.date = date;

		this.message = message;

		this.location = location;

	}

	public TweetBuilder tweetId(Long val) {
		this.tweetId = val;
		return this;
	}

	public TweetBuilder date(LocalDate val) {
		this.date = val;
		return this;
	}

	public TweetBuilder message(String val) {
		this.message = val;
		return this;
	}

	public TweetBuilder location(String val) {
		this.location = val;
		return this;
	}

	public Long getTweetId() {
		return tweetId;
	};

	public LocalDate getDate() {
		return date;
	};

	public String getMessage() {
		return message;
	};

	public String getLocation() {
		return location;
	};

	/**
	 * @return new Tweet instance constructed based on the values that have been set into this builder
	 */
	public Tweet build() {
		Tweet obj = new Tweet(getTweetId(), getDate(), getMessage(), getLocation());

		return obj;
	}
}
