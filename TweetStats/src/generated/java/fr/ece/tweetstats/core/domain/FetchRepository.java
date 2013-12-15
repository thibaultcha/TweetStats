package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.core.exception.FetchNotFoundException;
import java.util.List;

/**
 * Generated interface for Repository for Fetch
 */
public interface FetchRepository {

	public final static String BEAN_ID = "fetchRepository";

	public List<Tweet> fetchResults();

	public Fetch findById(String id) throws FetchNotFoundException;

	public List<Fetch> findAll();

	public Fetch save(Fetch entity);

	public void delete(Fetch entity);

}
