package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.TweetProperties.TweetProperty;
import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link fr.ece.tweetstats.core.domain.Fetch}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class FetchProperties {

	private FetchProperties() {
	}

	private static final FetchPropertiesImpl<Fetch> sharedInstance = new FetchPropertiesImpl<Fetch>(Fetch.class);

	public static Property<Fetch> id() {
		return sharedInstance.id();
	}

	public static Property<Fetch> lastFetchDate() {
		return sharedInstance.lastFetchDate();
	}

	public static Property<Fetch> brand() {
		return sharedInstance.brand();
	}

	public static Property<Fetch> adjective() {
		return sharedInstance.adjective();
	}

	public static Property<Fetch> lastId() {
		return sharedInstance.lastId();
	}

	public static Property<Fetch> fetchedFromTwitter() {
		return sharedInstance.fetchedFromTwitter();
	}

	public static Property<Fetch> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Fetch> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Fetch> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Fetch> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Fetch> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Fetch> version() {
		return sharedInstance.version();
	}

	public static TweetProperty<Fetch> results() {
		return sharedInstance.results();
	}

	/**
	 * This class is used for references to {@link fr.ece.tweetstats.core.domain.Fetch}, i.e. nested property.
	 */
	public static class FetchProperty<T> extends FetchPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public FetchProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class FetchPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		FetchPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		FetchPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "_id", false, owningClass);
		}

		public Property<T> lastFetchDate() {
			return new LeafProperty<T>(getParentPath(), "lastFetchDate", false, owningClass);
		}

		public Property<T> brand() {
			return new LeafProperty<T>(getParentPath(), "brand", false, owningClass);
		}

		public Property<T> adjective() {
			return new LeafProperty<T>(getParentPath(), "adjective", false, owningClass);
		}

		public Property<T> lastId() {
			return new LeafProperty<T>(getParentPath(), "lastId", false, owningClass);
		}

		public Property<T> fetchedFromTwitter() {
			return new LeafProperty<T>(getParentPath(), "fetchedFromTwitter", false, owningClass);
		}

		public Property<T> uuid() {
			return new LeafProperty<T>(getParentPath(), "uuid", false, owningClass);
		}

		public Property<T> createdDate() {
			return new LeafProperty<T>(getParentPath(), "createdDate", false, owningClass);
		}

		public Property<T> createdBy() {
			return new LeafProperty<T>(getParentPath(), "createdBy", false, owningClass);
		}

		public Property<T> lastUpdated() {
			return new LeafProperty<T>(getParentPath(), "lastUpdated", false, owningClass);
		}

		public Property<T> lastUpdatedBy() {
			return new LeafProperty<T>(getParentPath(), "lastUpdatedBy", false, owningClass);
		}

		public Property<T> version() {
			return new LeafProperty<T>(getParentPath(), "version", false, owningClass);
		}

		public TweetProperty<T> results() {
			return new TweetProperty<T>(getParentPath(), "results", owningClass);
		}
	}
}
