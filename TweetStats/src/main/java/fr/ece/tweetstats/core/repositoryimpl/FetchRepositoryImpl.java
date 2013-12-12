package fr.ece.tweetstats.core.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.ece.tweetstats.core.domain.Tweet;

/**
 * Repository implementation for Fetch
 */
@Repository("fetchRepository")
public class FetchRepositoryImpl extends FetchRepositoryBase {

	public FetchRepositoryImpl() {
	}

	public List<Tweet> fetchResults() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("fetchResults not implemented");
	}

}
