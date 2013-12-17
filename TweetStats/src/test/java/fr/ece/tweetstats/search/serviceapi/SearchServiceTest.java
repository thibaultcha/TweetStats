package fr.ece.tweetstats.search.serviceapi;

import fr.ece.tweetstats.search.domain.Search;
import fr.ece.tweetstats.search.serviceapi.SearchService;

import java.util.List;
import java.util.Set;

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
public class SearchServiceTest extends AbstractJUnit4SpringContextTests implements SearchServiceTestBase {

	@Autowired
	private DbManager dbManager;

	@Autowired
	private SearchService searchService;

	private Search search;
	private String searchId;
	
	@Before
	public void initTestData() {
		search = new Search();
		search.setBrand("RATP");
		searchService.save(search);
		
		searchId = search.getId();
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
	public void testFindById() throws Exception {
		Search findSearch = searchService.findById(searchId);
		
		assertEquals("RATP", findSearch.getBrand());
	}

	@Test
	public void testFindAll() throws Exception {
		List<Search> searches = searchService.findAll();
		
		assertTrue(searches instanceof List);
	}

	@Test
	public void testSave() throws Exception {
		Search savedSearch = new Search();
		savedSearch.setBrand("Alloresto");
		searchService.save(savedSearch);
		
		assertNotEquals(savedSearch.getId(), null);
	}

	@Test
	public void testDelete() throws Exception {
		searchService.delete(search);
		List<Search> searches = searchService.findAll();
		
		
		assertEquals(0, searches.size());
	}

	@Test
	public void testGetSearchByBrand() throws Exception {
		List<Search> searches = searchService.getSearchByBrand("RATP");
		
		assertEquals(1, searches.size());
	}
}
