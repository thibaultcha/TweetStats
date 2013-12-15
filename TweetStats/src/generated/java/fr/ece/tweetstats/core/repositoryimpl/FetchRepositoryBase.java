package fr.ece.tweetstats.core.repositoryimpl;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.FetchRepository;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.core.exception.FetchNotFoundException;
import fr.ece.tweetstats.core.mapper.FetchMapper;
import java.util.List;
import javax.annotation.PostConstruct;
import org.sculptor.framework.accessapi.DeleteAccess;
import org.sculptor.framework.accessapi.FindAllAccess;
import org.sculptor.framework.accessapi.FindByIdAccess;
import org.sculptor.framework.accessapi.SaveAccess;
import org.sculptor.framework.accessimpl.mongodb.DataMapper;
import org.sculptor.framework.accessimpl.mongodb.DbManager;
import org.sculptor.framework.accessimpl.mongodb.EnumMapper;
import org.sculptor.framework.accessimpl.mongodb.IndexSpecification;
import org.sculptor.framework.accessimpl.mongodb.JodaDateTimeMapper;
import org.sculptor.framework.accessimpl.mongodb.JodaLocalDateMapper;
import org.sculptor.framework.accessimpl.mongodb.MongoDbDeleteAccessImpl;
import org.sculptor.framework.accessimpl.mongodb.MongoDbFindAllAccessImpl;
import org.sculptor.framework.accessimpl.mongodb.MongoDbFindByIdAccessImpl;
import org.sculptor.framework.accessimpl.mongodb.MongoDbSaveAccessImpl;
import org.springframework.beans.factory.annotation.Autowired;

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
public abstract class FetchRepositoryBase implements FetchRepository {

	public FetchRepositoryBase() {
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindByIdAccess}
	 */
	public Fetch findById(String id) throws FetchNotFoundException {

		FindByIdAccess<Fetch, String> ao = createFindByIdAccess();

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

		FindAllAccess<Fetch> ao = createFindAllAccess();

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

	@Autowired
	private DbManager dbManager;

	protected DbManager getDbManager() {
		return dbManager;
	}

	protected FindByIdAccess<Fetch, String> createFindByIdAccess() {
		MongoDbFindByIdAccessImpl<Fetch, String> ao = new MongoDbFindByIdAccessImpl<Fetch, String>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(FetchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected FindAllAccess<Fetch> createFindAllAccess() {
		MongoDbFindAllAccessImpl<Fetch> ao = new MongoDbFindAllAccessImpl<Fetch>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(FetchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected SaveAccess<Fetch> createSaveAccess() {
		MongoDbSaveAccessImpl<Fetch> ao = new MongoDbSaveAccessImpl<Fetch>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(FetchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected DeleteAccess<Fetch> createDeleteAccess() {
		MongoDbDeleteAccessImpl<Fetch> ao = new MongoDbDeleteAccessImpl<Fetch>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(FetchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected Class<Fetch> getPersistentClass() {
		return Fetch.class;
	}

	@SuppressWarnings("unchecked")
	private org.sculptor.framework.accessimpl.mongodb.DataMapper[] additionalDataMappers = new DataMapper[] {
			JodaLocalDateMapper.getInstance(), JodaDateTimeMapper.getInstance(), EnumMapper.getInstance() };

	@SuppressWarnings("unchecked")
	protected DataMapper<Object, DBObject>[] getAdditionalDataMappers() {
		return additionalDataMappers;
	}

	@PostConstruct
	protected void ensureIndex() {
		DBCollection dbCollection = dbManager.getDBCollection(FetchMapper.getInstance().getDBCollectionName());
		for (IndexSpecification each : FetchMapper.getInstance().indexes()) {
			dbCollection.ensureIndex(each.getKeys(), each.getName(), each.isUnique());
		}
	}

}
