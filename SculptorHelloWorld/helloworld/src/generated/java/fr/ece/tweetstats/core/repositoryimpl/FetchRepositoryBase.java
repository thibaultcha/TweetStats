package fr.ece.tweetstats.core.repositoryimpl;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.FetchRepository;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.core.exception.FetchNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sculptor.framework.accessapi.DeleteAccess;
import org.sculptor.framework.accessapi.FindAllAccess2;
import org.sculptor.framework.accessapi.FindByIdAccess;
import org.sculptor.framework.accessapi.SaveAccess;
import org.sculptor.framework.accessimpl.jpa2.JpaDeleteAccessImpl;
import org.sculptor.framework.accessimpl.jpa2.JpaFindAllAccessImplGeneric;
import org.sculptor.framework.accessimpl.jpa2.JpaFindByIdAccessImpl;
import org.sculptor.framework.accessimpl.jpa2.JpaSaveAccessImpl;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * Generated base class for implementation of Repository for Fetch
 * 
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 *      @org.springframework.stereotype.Repository("fetchRepository")
 * </pre>
 * 
 */
public abstract class FetchRepositoryBase extends JpaDaoSupport implements FetchRepository {

	public FetchRepositoryBase() {
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindByIdAccess}
	 */
	public Fetch findById(Long id) throws FetchNotFoundException {

		FindByIdAccess<Fetch, Long> ao = createFindByIdAccess();

		ao.setId(id);
		ao.execute();
		if (ao.getResult() == null) {
			throw new FetchNotFoundException("No Fetch found with id: " + id);
		}
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindAllAccess}
	 */
	public List<Fetch> findAll() {
		return findAll(getPersistentClass());
	}

	public <R> List<R> findAll(Class<R> resultType) {

		FindAllAccess2<R> ao = createFindAllAccess(resultType);

		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.SaveAccess}
	 */
	public Fetch save(Fetch entity) {

		SaveAccess<Fetch> ao = createSaveAccess();

		ao.setEntity(entity);
		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.DeleteAccess}
	 */
	public void delete(Fetch entity) {

		DeleteAccess<Fetch> ao = createDeleteAccess();

		ao.setEntity(entity);
		ao.execute();
	}

	public abstract List<Tweet> fetchResults();

	private EntityManager entityManager;

	/**
	 * Dependency injection
	 */
	@PersistenceContext(unitName = "TweetStatsEntityManagerFactory")
	protected void setEntityManagerDependency(EntityManager entityManager) {
		this.entityManager = entityManager;
		// for JpaDaoSupport, JpaTemplate
		setEntityManager(entityManager);
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected FindByIdAccess<Fetch, Long> createFindByIdAccess() {
		JpaFindByIdAccessImpl<Fetch, Long> ao = new JpaFindByIdAccessImpl<Fetch, Long>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	// convenience method
	protected FindAllAccess2<Fetch> createFindAllAccess() {
		return createFindAllAccess(getPersistentClass(), getPersistentClass());
	}

	// convenience method
	protected <R> FindAllAccess2<R> createFindAllAccess(Class<R> resultType) {
		return createFindAllAccess(getPersistentClass(), resultType);
	}

	protected <T, R> FindAllAccess2<R> createFindAllAccess(Class<T> type, Class<R> resultType) {
		JpaFindAllAccessImplGeneric<T, R> ao = new JpaFindAllAccessImplGeneric<T, R>(type, resultType);
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected SaveAccess<Fetch> createSaveAccess() {
		JpaSaveAccessImpl<Fetch> ao = new JpaSaveAccessImpl<Fetch>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected DeleteAccess<Fetch> createDeleteAccess() {
		JpaDeleteAccessImpl<Fetch> ao = new JpaDeleteAccessImpl<Fetch>(getPersistentClass());
		ao.setEntityManager(getEntityManager());
		return ao;
	}

	protected Class<Fetch> getPersistentClass() {
		return Fetch.class;
	}

}
