package fr.ece.tweetstats.core.domain;

import fr.ece.tweetstats.core.domain.Search;
import fr.ece.tweetstats.core.exception.SearchNotFoundException;
import java.util.List;

/**
 * Generated interface for Repository for Search
 */
public interface SearchRepository {

	public final static String BEAN_ID = "searchRepository";

	public List<Search> findByBrand(String brand);

	public Search findById(String id) throws SearchNotFoundException;

	public List<Search> findAll();

	public Search save(Search entity);

	public void delete(Search entity);

}
