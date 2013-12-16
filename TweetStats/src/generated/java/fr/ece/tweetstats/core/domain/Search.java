package fr.ece.tweetstats.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.joda.time.DateTime;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.domain.JodaAuditable;

/**
 * EntityImpl representing Search.
 */

public class Search extends AbstractDomainObject implements JodaAuditable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String brand;
	private List<String> adjectives = new ArrayList<String>();
	private String uuid;
	private DateTime createdDate;
	private String createdBy;
	private DateTime lastUpdated;
	private String lastUpdatedBy;
	private Long version;

	public Search() {
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

	public String getBrand() {
		return brand;
	};

	public void setBrand(String brand) {
		this.brand = brand;
	};

	public List<String> getAdjectives() {
		return adjectives;
	};

	public void setAdjectives(List<String> adjectives) {
		this.adjectives = adjectives;
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

	/**
	 * This method is used by equals and hashCode.
	 * 
	 * @return {{@link #getUuid}
	 */
	public Object getKey() {
		return getUuid();
	}

}
