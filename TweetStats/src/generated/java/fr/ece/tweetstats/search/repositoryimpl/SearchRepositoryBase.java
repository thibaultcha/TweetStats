package fr.ece.tweetstats.search.repositoryimpl;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import fr.ece.tweetstats.search.domain.Search;
import fr.ece.tweetstats.search.domain.SearchProperties;
import fr.ece.tweetstats.search.domain.SearchRepository;
import fr.ece.tweetstats.search.exception.SearchNotFoundException;
import fr.ece.tweetstats.search.mapper.SearchMapper;
import java.util.List;
import javax.annotation.PostConstruct;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.sculptor.framework.accessapi.DeleteAccess;
import org.sculptor.framework.accessapi.FindAllAccess;
import org.sculptor.framework.accessapi.FindByConditionAccess;
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
import org.sculptor.framework.accessimpl.mongodb.MongoDbFindByConditionAccessImpl;
import org.sculptor.framework.accessimpl.mongodb.MongoDbFindByIdAccessImpl;
import org.sculptor.framework.accessimpl.mongodb.MongoDbSaveAccessImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generated base class for implementation of Repository for Search
 * 
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 *      @org.springframework.stereotype.Repository("searchRepository")
 * </pre>
 * 
 */
public abstract class SearchRepositoryBase implements SearchRepository {

	public SearchRepositoryBase() {
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindByConditionAccess}
	 */
	protected List<Search> findByCondition(List<ConditionalCriteria> condition) {

		FindByConditionAccess<Search> ao = createFindByConditionAccess();

		ao.setCondition(condition);
		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindByIdAccess}
	 */
	public Search findById(String id) throws SearchNotFoundException {

		FindByIdAccess<Search, String> ao = createFindByIdAccess();

		ao.setId(id);
		ao.execute();
		if (ao.getResult() == null) {
			throw new SearchNotFoundException("No Search found with id: " + id);
		}
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.FindAllAccess}
	 */
	public List<Search> findAll() {

		FindAllAccess<Search> ao = createFindAllAccess();

		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.SaveAccess}
	 */
	public Search save(Search entity) {

		SaveAccess<Search> ao = createSaveAccess();

		ao.setEntity(entity);
		ao.execute();
		return ao.getResult();
	}

	/**
	 * Delegates to {@link org.sculptor.framework.accessapi.DeleteAccess}
	 */
	public void delete(Search entity) {

		DeleteAccess<Search> ao = createDeleteAccess();

		ao.setEntity(entity);
		ao.execute();
	}

	public List<Search> findByBrand(String brand) {
		List<ConditionalCriteria> condition = ConditionalCriteriaBuilder.criteriaFor(Search.class)
				.withProperty(SearchProperties.brand()).eq(brand).build();

		List<Search> result = findByCondition(condition);
		return result;
	}

	@Autowired
	private DbManager dbManager;

	protected DbManager getDbManager() {
		return dbManager;
	}

	protected FindByConditionAccess<Search> createFindByConditionAccess() {
		MongoDbFindByConditionAccessImpl<Search> ao = new MongoDbFindByConditionAccessImpl<Search>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(SearchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected FindByIdAccess<Search, String> createFindByIdAccess() {
		MongoDbFindByIdAccessImpl<Search, String> ao = new MongoDbFindByIdAccessImpl<Search, String>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(SearchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected FindAllAccess<Search> createFindAllAccess() {
		MongoDbFindAllAccessImpl<Search> ao = new MongoDbFindAllAccessImpl<Search>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(SearchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected SaveAccess<Search> createSaveAccess() {
		MongoDbSaveAccessImpl<Search> ao = new MongoDbSaveAccessImpl<Search>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(SearchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected DeleteAccess<Search> createDeleteAccess() {
		MongoDbDeleteAccessImpl<Search> ao = new MongoDbDeleteAccessImpl<Search>(getPersistentClass());
		ao.setDbManager(dbManager);
		ao.setDataMapper(SearchMapper.getInstance());
		ao.setAdditionalDataMappers(getAdditionalDataMappers());
		return ao;
	}

	protected Class<Search> getPersistentClass() {
		return Search.class;
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
		DBCollection dbCollection = dbManager.getDBCollection(SearchMapper.getInstance().getDBCollectionName());
		for (IndexSpecification each : SearchMapper.getInstance().indexes()) {
			dbCollection.ensureIndex(each.getKeys(), each.getName(), each.isUnique());
		}
	}

}
