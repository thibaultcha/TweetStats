package fr.ece.tweetstats.core.mapper;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.core.mapper.TweetMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.sculptor.framework.accessimpl.mongodb.DataMapper;
import org.sculptor.framework.accessimpl.mongodb.IdReflectionUtil;
import org.sculptor.framework.accessimpl.mongodb.IndexSpecification;
import org.sculptor.framework.accessimpl.mongodb.JodaDateTimeMapper;
import org.sculptor.framework.accessimpl.mongodb.JodaLocalDateMapper;

public class FetchMapper implements DataMapper<Fetch, DBObject> {

	private static final FetchMapper instance = new FetchMapper();

	public static FetchMapper getInstance() {
		return instance;
	}

	protected FetchMapper() {
	}

	@Override
	public boolean canMapToData(Class<?> domainObjectClass) {
		if (domainObjectClass == null) {
			return true;
		}
		return Fetch.class.isAssignableFrom(domainObjectClass);
	}

	@Override
	public String getDBCollectionName() {
		return "Fetch";
	}

	@Override
	public Fetch toDomain(DBObject from) {
		if (from == null) {
			return null;
		}

		// Single reference in constructor param, persistent, and should be included in aggregate

		// Single reference in constructor param, not in same aggregate root (unowned reference)
		// TODO many references in constructor

		Fetch result = new Fetch();
		if (from.containsField("_id")) {
			ObjectId objectId = (ObjectId) from.get("_id");
			String idString = objectId.toStringMongod();
			IdReflectionUtil.internalSetId(result, idString);
		}
		if (from.containsField("uuid")) {
			IdReflectionUtil.internalSetUuid(result, (String) from.get("uuid"));
		}
		if (from.containsField("lastFetchDate")) {
			result.setLastFetchDate(JodaLocalDateMapper.getInstance().toDomain((Date) from.get("lastFetchDate")));
		}
		if (from.containsField("brand")) {
			result.setBrand((String) from.get("brand"));
		}
		if (from.containsField("adjective")) {
			result.setAdjective((String) from.get("adjective"));
		}
		if (from.containsField("lastId")) {
			result.setLastId((Long) from.get("lastId"));
		}
		if (from.containsField("fetchedFromTwitter")) {
			result.setFetchedFromTwitter((Integer) from.get("fetchedFromTwitter"));
		}
		if (from.containsField("createdDate")) {
			result.setCreatedDate(JodaDateTimeMapper.getInstance().toDomain((Date) from.get("createdDate")));
		}
		if (from.containsField("createdBy")) {
			result.setCreatedBy((String) from.get("createdBy"));
		}
		if (from.containsField("lastUpdated")) {
			result.setLastUpdated(JodaDateTimeMapper.getInstance().toDomain((Date) from.get("lastUpdated")));
		}
		if (from.containsField("lastUpdatedBy")) {
			result.setLastUpdatedBy((String) from.get("lastUpdatedBy"));
		}
		if (from.containsField("version")) {
			result.setVersion((Long) from.get("version"));
		}

		// Single reference not in constructor param, persistent, and should be included in aggregate

		// Multiple reference not in constructor param, persistent, and should be included in aggregate
		if (from.containsField("results")) {
			@SuppressWarnings("unchecked")
			Collection<DBObject> resultsData = (Collection<DBObject>) from.get("results");
			for (DBObject each : resultsData) {
				result.addResult(TweetMapper.getInstance().toDomain(each));
			}
		}

		// Single reference not in constructor param, not in same aggregate root (unowned reference)

		// Multiple reference not in constructor param, not in same aggregate root (unowned reference)

		return result;
	}

	@Override
	public DBObject toData(Fetch from) {
		if (from == null) {
			return null;
		}

		DBObject result = new BasicDBObject();
		if (from.getId() != null) {
			ObjectId objectId = ObjectId.massageToObjectId(from.getId());
			result.put("_id", objectId);
		}

		result.put("lastFetchDate", JodaLocalDateMapper.getInstance().toData(from.getLastFetchDate()));
		result.put("brand", from.getBrand());
		result.put("adjective", from.getAdjective());
		result.put("lastId", from.getLastId());
		result.put("fetchedFromTwitter", from.getFetchedFromTwitter());
		result.put("uuid", from.getUuid());
		result.put("createdDate", JodaDateTimeMapper.getInstance().toData(from.getCreatedDate()));
		result.put("createdBy", from.getCreatedBy());
		result.put("lastUpdated", JodaDateTimeMapper.getInstance().toData(from.getLastUpdated()));
		result.put("lastUpdatedBy", from.getLastUpdatedBy());
		result.put("version", from.getVersion());

		List<DBObject> resultsData = new ArrayList<DBObject>();
		for (Tweet each : from.getResults()) {
			resultsData.add(TweetMapper.getInstance().toData(each));
		}
		result.put("results", resultsData);

		return result;
	}

	@Override
	public List<IndexSpecification> indexes() {
		List<IndexSpecification> indexes = new ArrayList<IndexSpecification>();
		return indexes;
	}

}
