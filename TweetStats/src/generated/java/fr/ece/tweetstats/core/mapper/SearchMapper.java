package fr.ece.tweetstats.core.mapper;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import fr.ece.tweetstats.core.domain.Search;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.sculptor.framework.accessimpl.mongodb.DataMapper;
import org.sculptor.framework.accessimpl.mongodb.IdReflectionUtil;
import org.sculptor.framework.accessimpl.mongodb.IndexSpecification;
import org.sculptor.framework.accessimpl.mongodb.JodaDateTimeMapper;

public class SearchMapper implements DataMapper<Search, DBObject> {

	private static final SearchMapper instance = new SearchMapper();

	public static SearchMapper getInstance() {
		return instance;
	}

	protected SearchMapper() {
	}

	@Override
	public boolean canMapToData(Class<?> domainObjectClass) {
		if (domainObjectClass == null) {
			return true;
		}
		return Search.class.isAssignableFrom(domainObjectClass);
	}

	@Override
	public String getDBCollectionName() {
		return "Search";
	}

	@Override
	public Search toDomain(DBObject from) {
		if (from == null) {
			return null;
		}

		// Single reference in constructor param, persistent, and should be included in aggregate

		// Single reference in constructor param, not in same aggregate root (unowned reference)
		// TODO many references in constructor

		Search result = new Search();
		if (from.containsField("_id")) {
			ObjectId objectId = (ObjectId) from.get("_id");
			String idString = objectId.toStringMongod();
			IdReflectionUtil.internalSetId(result, idString);
		}
		if (from.containsField("uuid")) {
			IdReflectionUtil.internalSetUuid(result, (String) from.get("uuid"));
		}
		if (from.containsField("brand")) {
			result.setBrand((String) from.get("brand"));
		}
		if (from.containsField("adjectives")) {
			result.setAdjectives(new ArrayList<String>((Collection) from.get("adjectives")));
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

		// Single reference not in constructor param, not in same aggregate root (unowned reference)

		// Multiple reference not in constructor param, not in same aggregate root (unowned reference)

		return result;
	}

	@Override
	public DBObject toData(Search from) {
		if (from == null) {
			return null;
		}

		DBObject result = new BasicDBObject();
		if (from.getId() != null) {
			ObjectId objectId = ObjectId.massageToObjectId(from.getId());
			result.put("_id", objectId);
		}

		result.put("brand", from.getBrand());
		result.put("adjectives", new ArrayList<Object>(from.getAdjectives()));
		result.put("uuid", from.getUuid());
		result.put("createdDate", JodaDateTimeMapper.getInstance().toData(from.getCreatedDate()));
		result.put("createdBy", from.getCreatedBy());
		result.put("lastUpdated", JodaDateTimeMapper.getInstance().toData(from.getLastUpdated()));
		result.put("lastUpdatedBy", from.getLastUpdatedBy());
		result.put("version", from.getVersion());

		return result;
	}

	@Override
	public List<IndexSpecification> indexes() {
		List<IndexSpecification> indexes = new ArrayList<IndexSpecification>();
		return indexes;
	}

}
