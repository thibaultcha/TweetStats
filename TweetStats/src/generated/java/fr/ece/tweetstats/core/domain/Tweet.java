package fr.ece.tweetstats.core.domain;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.Validate;
import org.hibernate.annotations.Type;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.domain.Identifiable;
import org.sculptor.framework.util.EqualsHelper;

/**
 * ValueObjectImpl representing Tweet.
 */

@Entity
@Table(name = "TWEET")
@EntityListeners({})
public class Tweet extends AbstractDomainObject implements Identifiable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "TWEETID", nullable = false)
	@NotNull
	private Long tweetId;
	@Column(name = "DATE", nullable = false)
	@Type(type = "date")
	@NotNull
	private Date date;
	@Column(name = "MESSAGE", nullable = false, length = 100)
	@NotNull
	private String message;
	@Column(name = "UUID", nullable = false, length = 36, unique = true)
	private String uuid;

	protected Tweet() {
	}

	public Tweet(Long tweetId, Date date, String message) {
		super();
		Validate.notNull(tweetId, "Tweet.tweetId must not be null");
		this.tweetId = tweetId;
		Validate.notNull(date, "Tweet.date must not be null");
		this.date = date;
		Validate.notNull(message, "Tweet.message must not be null");
		this.message = message;
	}

	/**
	 * Creates a new Tweet. Typically used with static import to achieve fluent interface.
	 */
	public static Tweet tweet(Long tweetId, Date date, String message) {
		return new Tweet(tweetId, date, message);
	}

	public Long getId() {
		return id;
	};

	/**
	 * The id is not intended to be changed or assigned manually, but for test purpose it is allowed to assign the id.
	 */
	protected void setId(Long id) {
		if ((this.id != null) && !this.id.equals(id)) {
			throw new IllegalArgumentException("Not allowed to change the id property.");
		}
		this.id = id;
	};

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

	/**
	 * Creates a copy of this instance, but with another tweetId.
	 */
	public Tweet withTweetId(Long tweetId) {
		if (EqualsHelper.equals(tweetId, getTweetId())) {
			return this;
		}
		return new Tweet(tweetId, getDate(), getMessage());
	};

	/**
	 * Creates a copy of this instance, but with another date.
	 */
	public Tweet withDate(Date date) {
		if (EqualsHelper.equals(date, getDate())) {
			return this;
		}
		return new Tweet(getTweetId(), date, getMessage());
	};

	/**
	 * Creates a copy of this instance, but with another message.
	 */
	public Tweet withMessage(String message) {
		if (EqualsHelper.equals(message, getMessage())) {
			return this;
		}
		return new Tweet(getTweetId(), getDate(), message);
	};

	@PrePersist
	protected void prePersist() {
		getUuid();
	}

	/**
	 * This method is used by equals and hashCode.
	 * 
	 * @return {{@link #getUuid}
	 */
	public Object getKey() {
		return getUuid();
	}

}
