package fr.ece.tweetstats.core.serviceapi;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.serviceapi.FetchService;

import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sculptor.framework.accessimpl.mongodb.DbManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Spring based test with MongoDB.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class FetchServiceTest extends AbstractJUnit4SpringContextTests implements FetchServiceTestBase {

	@Autowired
	private DbManager dbManager;

	@Autowired
	private FetchService fetchService;

	private Fetch fetch;
	private String fetchId;
	
	@Before
	public void initTestData() {
		fetch = new Fetch();
		fetch.setBrand("RATP");
		fetch.setAdjective("grève");
		fetch.setLastFetchDate(new LocalDate());
		fetch.setLastId(1L);
		fetchService.save(fetch);
		
		fetchId = fetch.getId();
	}

	@Before
	public void initDbManagerThreadInstance() throws Exception {
		// to be able to do lazy loading of associations inside test class
		DbManager.setThreadInstance(dbManager);
	}

	@After
	public void dropDatabase() {
		Set<String> names = dbManager.getDB().getCollectionNames();
		for (String each : names) {
			if (!each.startsWith("system")) {
				dbManager.getDB().getCollection(each).drop();
			}
		}
		
		dbManager.getDB().dropDatabase();
	}

	private int countRowsInDBCollection(String name) {
		return (int) dbManager.getDBCollection(name).getCount();
	}

	@Test
	public void testGetFetchesWithBrandAndAdjective() throws Exception {
		List<Fetch> fetches = fetchService.getFetchesWithBrandAndAdjective("RATP", "grève");
		
		assertTrue(fetches instanceof List);
		assertEquals(1, fetches.size());
	}

	@Test
	public void testFindById() throws Exception {
		Fetch findFetch = fetchService.findById(fetchId);
		
		assertEquals("RATP", findFetch.getBrand());
	}

	@Test
	public void testFindAll() throws Exception {
		List<Fetch> fetches = fetchService.findAll();
		
		assertTrue(fetches instanceof List);
	}

	@Test
	public void testSave() throws Exception {
		Fetch savedFetch = new Fetch();
		savedFetch.setBrand("Alloresto");
		savedFetch.setAdjective("retard");
		savedFetch.setLastFetchDate(new LocalDate());
		savedFetch.setLastId(1L);
		fetchService.save(savedFetch);
		
		assertNotEquals(savedFetch.getId(), null);
	}

	@Test
	public void testDelete() throws Exception {
		fetchService.delete(fetch);
		List<Fetch> fetches = fetchService.findAll();
		
		
		assertEquals(0, fetches.size());
	}
}
