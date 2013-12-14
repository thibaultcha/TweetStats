package fr.ece.tweetstats.core.domain;

import java.util.UUID;
import org.apache.commons.lang.Validate;
import org.joda.time.LocalDate;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.util.EqualsHelper;

/**
 * ValueObjectImpl representing Tweet.
 */

public class Tweet extends AbstractDomainObject {

	private static final long serialVersionUID = 1L;

	private String id;
	private Long tweetId;
	private LocalDate date;
	private String message;
	private String location;
	private String uuid;

	protected Tweet() {
	}

	public Tweet(Long tweetId, LocalDate date, String message, String location) {
		super();
		Validate.notNull(tweetId, "Tweet.tweetId must not be null");
		this.tweetId = tweetId;
		Validate.notNull(date, "Tweet.date must not be null");
		this.date = date;
		Validate.notNull(message, "Tweet.message must not be null");
		this.message = message;
		Validate.notNull(location, "Tweet.location must not be null");
		this.location = location;
	}

	/**
	 * Creates a new Tweet. Typically used with static import to achieve fluent interface.
	 */
	public static Tweet tweet(Long tweetId, LocalDate date, String message, String location) {
		return new Tweet(tweetId, date, message, location);
	}

	public String getId() {
		return id;
	};

	/**
	 * The id is not intended to be changed or assigned manually, but for test purpose it is allowed to assign the id.
	 */
	protected void setId(String id) {
		if ((this.id != null) && !this.id.equals(id)) {
			throw new IllegalArgumentException("Not allowed to change the id property.");
		}
		this.id = id;
	};

	public Long getTweetId() {
		return tweetId;
	};

	@SuppressWarnings("unused")
	private void setTweetId(Long tweetId) {
		if ((this.tweetId != null) && !this.tweetId.equals(tweetId)) {
			throw new IllegalArgumentException("Not allowed to change the tweetId property.");
		}
		this.tweetId = tweetId;
	};

	public LocalDate getDate() {
		return date;
	};

	@SuppressWarnings("unused")
	private void setDate(LocalDate date) {
		if ((this.date != null) && !this.date.equals(date)) {
			throw new IllegalArgumentException("Not allowed to change the date property.");
		}
		this.date = date;
	};

	public String getMessage() {
		return message;
	};

	@SuppressWarnings("unused")
	private void setMessage(String message) {
		if ((this.message != null) && !this.message.equals(message)) {
			throw new IllegalArgumentException("Not allowed to change the message property.");
		}
		this.message = message;
	};

	public String getLocation() {
		return location;
	};

	@SuppressWarnings("unused")
	private void setLocation(String location) {
		if ((this.location != null) && !this.location.equals(location)) {
			throw new IllegalArgumentException("Not allowed to change the location property.");
		}
		this.location = location;
	};

	/**
	 * This domain object doesn't have a natural key and this random generated identifier is the unique identifier for this domain
	 * object.
	 */
	public String getUuid() {
		// lazy init of UUID
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}

	@SuppressWarnings("unused")
	private void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Creates a copy of this instance, but with another tweetId.
	 */
	public Tweet withTweetId(Long tweetId) {
		if (EqualsHelper.equals(tweetId, getTweetId())) {
			return this;
		}
		return new Tweet(tweetId, getDate(), getMessage(), getLocation());
	};

	/**
	 * Creates a copy of this instance, but with another date.
	 */
	public Tweet withDate(LocalDate date) {
		if (EqualsHelper.equals(date, getDate())) {
			return this;
		}
		return new Tweet(getTweetId(), date, getMessage(), getLocation());
	};

	/**
	 * Creates a copy of this instance, but with another message.
	 */
	public Tweet withMessage(String message) {
		if (EqualsHelper.equals(message, getMessage())) {
			return this;
		}
		return new Tweet(getTweetId(), getDate(), message, getLocation());
	};

	/**
	 * Creates a copy of this instance, but with another location.
	 */
	public Tweet withLocation(String location) {
		if (EqualsHelper.equals(location, getLocation())) {
			return this;
		}
		return new Tweet(getTweetId(), getDate(), getMessage(), location);
	};

	/**
	 * This method is used by equals and hashCode.
	 * 
	 * @return {{@link #getUuid}
	 */
	public Object getKey() {
		return getUuid();
	}

}
