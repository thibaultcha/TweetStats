package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Builder for Fetch class.
 */
public class FetchBuilder {

	private LocalDate lastFetchDate;
	private String brand;
	private String adjective;
	private Long lastId;
	private DateTime createdDate;
	private String createdBy;
	private DateTime lastUpdated;
	private String lastUpdatedBy;

	private List<Tweet> results = new ArrayList<Tweet>();

	/**
	 * Static factory method for FetchBuilder
	 */
	public static FetchBuilder fetch() {
		return new FetchBuilder();
	}

	public FetchBuilder() {
	}

	public FetchBuilder lastFetchDate(LocalDate val) {
		this.lastFetchDate = val;
		return this;
	}

	public FetchBuilder brand(String val) {
		this.brand = val;
		return this;
	}

	public FetchBuilder adjective(String val) {
		this.adjective = val;
		return this;
	}

	public FetchBuilder lastId(Long val) {
		this.lastId = val;
		return this;
	}

	public FetchBuilder createdDate(DateTime val) {
		this.createdDate = val;
		return this;
	}

	public FetchBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public FetchBuilder lastUpdated(DateTime val) {
		this.lastUpdated = val;
		return this;
	}

	public FetchBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	/**
	 * Adds an object to the to-many association. It is added the collection {@link #getResults}.
	 */
	public FetchBuilder addResult(Tweet resultElement) {
		getResults().add(resultElement);
		return this;
	}

	public LocalDate getLastFetchDate() {
		return lastFetchDate;
	};

	public String getBrand() {
		return brand;
	};

	public String getAdjective() {
		return adjective;
	};

	public Long getLastId() {
		return lastId;
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

	public List<Tweet> getResults() {
		return results;
	};

	/**
	 * @return new Fetch instance constructed based on the values that have been set into this builder
	 */
	public Fetch build() {
		Fetch obj = new Fetch();
		obj.setLastFetchDate(lastFetchDate);
		obj.setBrand(brand);
		obj.setAdjective(adjective);
		obj.setLastId(lastId);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);
		obj.getResults().addAll(results);

		return obj;
	}
}
