package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Tweet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Type;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.domain.AuditListener;
import org.sculptor.framework.domain.Auditable;
import org.sculptor.framework.domain.Identifiable;

/**
 * EntityImpl representing Fetch.
 */

@Entity
@Table(name = "FETCH")
@EntityListeners({ AuditListener.class })
public class Fetch extends AbstractDomainObject implements Auditable, Identifiable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DATE", nullable = false)
	@Type(type = "date")
	@NotNull
	private Date date;
	@Column(name = "BRAND", nullable = false, length = 100)
	@NotNull
	private String brand;
	@Column(name = "ADJECTIVE", nullable = false, length = 100)
	@NotNull
	private String adjective;
	@Column(name = "LASTID", nullable = false)
	@NotNull
	private Long lastId;
	@Column(name = "UUID", nullable = false, length = 36, unique = true)
	private String uuid;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDDATE")
	private Date createdDate;
	@Column(name = "CREATEDBY", length = 50)
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTUPDATED")
	private Date lastUpdated;
	@Column(name = "LASTUPDATEDBY", length = 50)
	private String lastUpdatedBy;
	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FETCH_RESULT", joinColumns = @JoinColumn(name = "FETCH"), inverseJoinColumns = @JoinColumn(name = "RESULT"))
	@ForeignKey(name = "FK_FETCH_RESULT_FETCH", inverseName = "FK_FETCH_RESULT_RESULT")
	@NotNull
	private Set<Tweet> results = new HashSet<Tweet>();

	public Fetch() {
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

	public Date getDate() {
		return date;
	};

	public void setDate(Date date) {
		this.date = date;
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

	public Date getCreatedDate() {
		return createdDate;
	};

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	};

	public String getCreatedBy() {
		return createdBy;
	};

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	};

	public Date getLastUpdated() {
		return lastUpdated;
	};

	public void setLastUpdated(Date lastUpdated) {
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

	public Set<Tweet> getResults() {
		return results;
	};

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
