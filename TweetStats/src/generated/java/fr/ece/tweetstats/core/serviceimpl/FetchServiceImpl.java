package fr.ece.tweetstats.core.serviceimpl;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.FetchRepository;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.core.exception.FetchNotFoundException;
import fr.ece.tweetstats.core.serviceapi.FetchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FetchService.
 */
@Service("fetchService")
public class FetchServiceImpl implements FetchService {

	public FetchServiceImpl() {
	}

	@Autowired
	private FetchRepository fetchRepository;

	protected FetchRepository getFetchRepository() {
		return fetchRepository;
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.core.domain.FetchRepository#fetchResults}
	 */
	protected List<Tweet> fetchResults() {
		return fetchRepository.fetchResults();
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.core.domain.FetchRepository#findById}
	 */
	public Fetch findById(String id) throws FetchNotFoundException {
		return fetchRepository.findById(id);
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.core.domain.FetchRepository#findAll}
	 */
	public List<Fetch> findAll() {
		return fetchRepository.findAll();
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.core.domain.FetchRepository#save}
	 */
	public Fetch save(Fetch entity) {
		return fetchRepository.save(entity);
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.core.domain.FetchRepository#delete}
	 */
	public void delete(Fetch entity) {
		fetchRepository.delete(entity);
	}

}
