package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Tweet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.domain.JodaAuditable;

/**
 * EntityImpl representing Fetch.
 */

public class Fetch extends AbstractDomainObject implements JodaAuditable {

	private static final long serialVersionUID = 1L;

	private String id;
	private LocalDate lastFetchDate;
	private String brand;
	private String adjective;
	private Long lastId;
	private Integer fetchedFromTwitter;
	private String uuid;
	private DateTime createdDate;
	private String createdBy;
	private DateTime lastUpdated;
	private String lastUpdatedBy;
	private Long version;

	private List<Tweet> results = new ArrayList<Tweet>();

	public Fetch() {
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

	public LocalDate getLastFetchDate() {
		return lastFetchDate;
	};

	public void setLastFetchDate(LocalDate lastFetchDate) {
		this.lastFetchDate = lastFetchDate;
	};

	public String getBrand() {
		return brand;
	};

	public void setBrand(String brand) {
		this.brand = brand;
	};

	public String getAdjective() {
		return adjective;
	};

	public void setAdjective(String adjective) {
		this.adjective = adjective;
	};

	public Long getLastId() {
		return lastId;
	};

	public void setLastId(Long lastId) {
		this.lastId = lastId;
	};

	public Integer getFetchedFromTwitter() {
		return fetchedFromTwitter;
	};

	public void setFetchedFromTwitter(Integer fetchedFromTwitter) {
		this.fetchedFromTwitter = fetchedFromTwitter;
	};

	public DateTime getCreatedDate() {
		return createdDate;
	};

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	};

	public String getCreatedBy() {
		return createdBy;
	};

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	};

	public DateTime getLastUpdated() {
		return lastUpdated;
	};

	public void setLastUpdated(DateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	};

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	};

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	};

	public Long getVersion() {
		return version;
	};

	public void setVersion(Long version) {
		this.version = version;
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

	public List<Tweet> getResults() {
		return results;
	};

	@SuppressWarnings("unused")
	private void setResults(List<Tweet> results) {
		this.results = results;
	}

	/**
	 * Adds an object to the unidirectional to-many association. It is added the collection {@link #getResults}.
	 */
	public void addResult(Tweet resultElement) {
		getResults().add(resultElement);
	};

	/**
	 * Removes an object from the unidirectional to-many association. It is removed from the collection {@link #getResults}.
	 */
	public void removeResult(Tweet resultElement) {
		getResults().remove(resultElement);
	};

	/**
	 * Removes all object from the unidirectional to-many association. All elements are removed from the collection
	 * {@link #getResults}.
	 */
	public void removeAllResults() {
		getResults().clear();
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
