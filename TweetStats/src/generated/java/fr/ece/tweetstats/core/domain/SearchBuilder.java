package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Search;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Builder for Search class.
 */
public class SearchBuilder {

	private String brand;
	private List<String> adjectives = new ArrayList<String>();
	private DateTime createdDate;
	private String createdBy;
	private DateTime lastUpdated;
	private String lastUpdatedBy;

	/**
	 * Static factory method for SearchBuilder
	 */
	public static SearchBuilder search() {
		return new SearchBuilder();
	}

	public SearchBuilder() {
	}

	public SearchBuilder brand(String val) {
		this.brand = val;
		return this;
	}

	public SearchBuilder adjectives(List<String> val) {
		this.adjectives = val;
		return this;
	}

	public SearchBuilder createdDate(DateTime val) {
		this.createdDate = val;
		return this;
	}

	public SearchBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public SearchBuilder lastUpdated(DateTime val) {
		this.lastUpdated = val;
		return this;
	}

	public SearchBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	public String getBrand() {
		return brand;
	};

	public List<String> getAdjectives() {
		return adjectives;
	};

	public DateTime getCreatedDate() {
		return createdDate;
	};

	public String getCreatedBy() {
		return createdBy;
	};

	public DateTime getLastUpdated() {
		return lastUpdated;
	};

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	};

	/**
	 * @return new Search instance constructed based on the values that have been set into this builder
	 */
	public Search build() {
		Search obj = new Search();
		obj.setBrand(brand);
		obj.setAdjectives(adjectives);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);

		return obj;
	}
}
