package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Tweet;
import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link fr.ece.tweetstats.core.domain.Tweet}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class TweetProperties {

	private TweetProperties() {
	}

	private static final TweetPropertiesImpl<Tweet> sharedInstance = new TweetPropertiesImpl<Tweet>(Tweet.class);

	public static Property<Tweet> id() {
		return sharedInstance.id();
	}

	public static Property<Tweet> tweetId() {
		return sharedInstance.tweetId();
	}

	public static Property<Tweet> date() {
		return sharedInstance.date();
	}

	public static Property<Tweet> message() {
		return sharedInstance.message();
	}

	public static Property<Tweet> location() {
		return sharedInstance.location();
	}

	public static Property<Tweet> uuid() {
		return sharedInstance.uuid();
	}

	/**
	 * This class is used for references to {@link fr.ece.tweetstats.core.domain.Tweet}, i.e. nested property.
	 */
	public static class TweetProperty<T> extends TweetPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public TweetProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class TweetPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		TweetPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		TweetPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "_id", false, owningClass);
		}

		public Property<T> tweetId() {
			return new LeafProperty<T>(getParentPath(), "tweetId", false, owningClass);
		}

		public Property<T> date() {
			return new LeafProperty<T>(getParentPath(), "date", false, owningClass);
		}

		public Property<T> message() {
			return new LeafProperty<T>(getParentPath(), "message", false, owningClass);
		}

		public Property<T> location() {
			return new LeafProperty<T>(getParentPath(), "location", false, owningClass);
		}

		public Property<T> uuid() {
			return new LeafProperty<T>(getParentPath(), "uuid", false, owningClass);
		}
	}
}
