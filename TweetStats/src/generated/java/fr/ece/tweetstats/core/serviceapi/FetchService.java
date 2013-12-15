package fr.ece.tweetstats.core.serviceapi;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.exception.FetchNotFoundException;
import java.util.List;

/**
 * Generated interface for the Service FetchService.
 */
public interface FetchService {

	public final static String BEAN_ID = "fetchService";

	public List<Fetch> getFetchesWithBrandAndAdjective(String brand, String adjective);

	public Fetch findById(String id) throws FetchNotFoundException;

	public List<Fetch> findAll();

	public Fetch save(Fetch entity);

	public void delete(Fetch entity);

}
