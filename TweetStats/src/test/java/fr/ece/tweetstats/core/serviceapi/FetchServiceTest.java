package fr.ece.tweetstats.core.serviceapi;

import java.util.Date;
import java.util.List;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.serviceapi.FetchService;

import org.junit.Before;
import org.junit.Test;
import org.sculptor.framework.errorhandling.SimpleJUnitServiceContextFactory;
import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Spring based transactional test with DbUnit support.
 */
public class FetchServiceTest extends AbstractDbUnitJpaTests implements FetchServiceTestBase {

	@Autowired
	protected FetchService fetchService;

	private Long fetchId;
	
	@Before
	public void initTestData() {
	    Fetch fetch = new Fetch();
	    fetch.setBrand("RATP");
	    fetch.setAdjective("Mauvais service");
	    fetch.setDate(new Date());
	    fetch.setLastId(new Long(1234));
	    fetch.setCreatedDate(new Date());
	    
	    Fetch saved = fetchService.save(SimpleJUnitServiceContextFactory.getServiceContext(), fetch);
	    this.fetchId = saved.getId();
	    
	    Fetch fetch2 = new Fetch();
	    fetch2.setBrand("Alloresto");
	    fetch2.setAdjective("Retard");
	    fetch2.setDate(new Date());
	    fetch2.setLastId(new Long(1234));
	    fetch2.setCreatedDate(new Date());
	    
	    fetchService.save(SimpleJUnitServiceContextFactory.getServiceContext(), fetch2);
	}

	@Test
	public void testFindById() throws Exception {
		Fetch found = fetchService.findById(SimpleJUnitServiceContextFactory.getServiceContext(), this.fetchId);
		assertEquals("RATP", found.getBrand());
	}

	@Override
	public void testFindAll() throws Exception {
		List<Fetch> fetches = fetchService.findAll(SimpleJUnitServiceContextFactory.getServiceContext());
		assertEquals(2, fetches.size());
	}

	@Override
	public void testSave() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
