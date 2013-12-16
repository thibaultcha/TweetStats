package fr.ece.tweetstats.search.serviceimpl;

import fr.ece.tweetstats.search.domain.Search;
import fr.ece.tweetstats.search.domain.SearchRepository;
import fr.ece.tweetstats.search.exception.SearchNotFoundException;
import fr.ece.tweetstats.search.serviceapi.SearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of SearchService.
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {

	public SearchServiceImpl() {
	}

	@Autowired
	private SearchRepository searchRepository;

	protected SearchRepository getSearchRepository() {
		return searchRepository;
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.search.domain.SearchRepository#findByBrand}
	 */
	public List<Search> getSearchByBrand(String brand) {
		return searchRepository.findByBrand(brand);
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.search.domain.SearchRepository#findById}
	 */
	public Search findById(String id) throws SearchNotFoundException {
		return searchRepository.findById(id);
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.search.domain.SearchRepository#findAll}
	 */
	public List<Search> findAll() {
		return searchRepository.findAll();
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.search.domain.SearchRepository#save}
	 */
	public Search save(Search entity) {
		return searchRepository.save(entity);
	}

	/**
	 * Delegates to {@link fr.ece.tweetstats.search.domain.SearchRepository#delete}
	 */
	public void delete(Search entity) {
		searchRepository.delete(entity);
	}

}
