package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Search;
import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link fr.ece.tweetstats.core.domain.Search}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class SearchProperties {

	private SearchProperties() {
	}

	private static final SearchPropertiesImpl<Search> sharedInstance = new SearchPropertiesImpl<Search>(Search.class);

	public static Property<Search> id() {
		return sharedInstance.id();
	}

	public static Property<Search> brand() {
		return sharedInstance.brand();
	}

	public static Property<Search> adjectives() {
		return sharedInstance.adjectives();
	}

	public static Property<Search> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Search> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Search> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Search> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Search> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Search> version() {
		return sharedInstance.version();
	}

	/**
	 * This class is used for references to {@link fr.ece.tweetstats.core.domain.Search}, i.e. nested property.
	 */
	public static class SearchProperty<T> extends SearchPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public SearchProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class SearchPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		SearchPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		SearchPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "_id", false, owningClass);
		}

		public Property<T> brand() {
			return new LeafProperty<T>(getParentPath(), "brand", false, owningClass);
		}

		public Property<T> adjectives() {
			return new LeafProperty<T>(getParentPath(), "adjectives", false, owningClass);
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
	}
}
