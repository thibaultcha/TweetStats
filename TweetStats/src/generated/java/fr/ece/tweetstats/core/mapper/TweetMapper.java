package fr.ece.tweetstats.core.mapper;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import fr.ece.tweetstats.core.domain.Tweet;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.joda.time.LocalDate;
import org.sculptor.framework.accessimpl.mongodb.DataMapper;
import org.sculptor.framework.accessimpl.mongodb.IdReflectionUtil;
import org.sculptor.framework.accessimpl.mongodb.IndexSpecification;
import org.sculptor.framework.accessimpl.mongodb.JodaLocalDateMapper;

public class TweetMapper implements DataMapper<Tweet, DBObject> {

	private static final TweetMapper instance = new TweetMapper();

	public static TweetMapper getInstance() {
		return instance;
	}

	protected TweetMapper() {
	}

	@Override
	public boolean canMapToData(Class<?> domainObjectClass) {
		if (domainObjectClass == null) {
			return true;
		}
		return Tweet.class.isAssignableFrom(domainObjectClass);
	}

	@Override
	public String getDBCollectionName() {
		return "Tweet";
	}

	@Override
	public Tweet toDomain(DBObject from) {
		if (from == null) {
			return null;
		}

		Long tweetId = (Long) from.get("tweetId");
		LocalDate date = JodaLocalDateMapper.getInstance().toDomain((Date) from.get("date"));
		String message = (String) from.get("message");
		String location = (String) from.get("location");

		// Single reference in constructor param, persistent, and should be included in aggregate

		// Single reference in constructor param, not in same aggregate root (unowned reference)
		// TODO many references in constructor

		Tweet result = new Tweet(tweetId, date, message, location);
		if (from.containsField("_id")) {
			ObjectId objectId = (ObjectId) from.get("_id");
			String idString = objectId.toStringMongod();
			IdReflectionUtil.internalSetId(result, idString);
		}
		if (from.containsField("uuid")) {
			IdReflectionUtil.internalSetUuid(result, (String) from.get("uuid"));
		}

		// Single reference not in constructor param, persistent, and should be included in aggregate

		// Multiple reference not in constructor param, persistent, and should be included in aggregate

		// Single reference not in constructor param, not in same aggregate root (unowned reference)

		// Multiple reference not in constructor param, not in same aggregate root (unowned reference)

		return result;
	}

	@Override
	public DBObject toData(Tweet from) {
		if (from == null) {
			return null;
		}

		DBObject result = new BasicDBObject();
		if (from.getId() != null) {
			ObjectId objectId = ObjectId.massageToObjectId(from.getId());
			result.put("_id", objectId);
		}

		result.put("tweetId", from.getTweetId());
		result.put("date", JodaLocalDateMapper.getInstance().toData(from.getDate()));
		result.put("message", from.getMessage());
		result.put("location", from.getLocation());
		result.put("uuid", from.getUuid());

		return result;
	}

	@Override
	public List<IndexSpecification> indexes() {
		return Collections.emptyList();
	}

}
