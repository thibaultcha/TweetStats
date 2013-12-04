package fr.ece.tweetstats.core.serviceapi;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.exception.FetchNotFoundException;
import java.util.List;
import org.sculptor.framework.errorhandling.ServiceContext;

/**
 * Generated interface for the Service FetchService.
 */
public interface FetchService {

	public final static String BEAN_ID = "fetchService";

	public Fetch findById(ServiceContext ctx, Long id) throws FetchNotFoundException;

	public List<Fetch> findAll(ServiceContext ctx);

	public Fetch save(ServiceContext ctx, Fetch entity);

	public void delete(ServiceContext ctx, Fetch entity);

}
