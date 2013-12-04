package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Builder for Fetch class.
 */
public class FetchBuilder {

	private Date date;
	private String brand;
	private String adjective;
	private Long lastId;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	private Set<Tweet> results = new HashSet<Tweet>();

	/**
	 * Static factory method for FetchBuilder
	 */
	public static FetchBuilder fetch() {
		return new FetchBuilder();
	}

	public FetchBuilder() {
	}

	public FetchBuilder date(Date val) {
		this.date = val;
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

	public FetchBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public FetchBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public FetchBuilder lastUpdated(Date val) {
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

	public Date getDate() {
		return date;
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

	public Date getCreatedDate() {
		return createdDate;
	};

	public String getCreatedBy() {
		return createdBy;
	};

	public Date getLastUpdated() {
		return lastUpdated;
	};

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	};

	public Set<Tweet> getResults() {
		return results;
	};

	/**
	 * @return new Fetch instance constructed based on the values that have been set into this builder
	 */
	public Fetch build() {
		Fetch obj = new Fetch();
		obj.setDate(date);
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
