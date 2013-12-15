package fr.ece.tweetstats.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sculptor.framework.accessimpl.mongodb.DbManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.serviceapi.FetchService;
import fr.ece.tweetstats.core.serviceapi.FetchServiceTestBase;

/**
 * Spring based test with MongoDB.
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class FetchServiceTest extends AbstractJUnit4SpringContextTests implements FetchServiceTestBase {

	@Autowired
    private DbManager dbManager;
	
	@Autowired
    private FetchService fetchService;
	
	private Fetch fetch;
	
	@Before
    public void initTestData() {
		fetch = new Fetch();
		fetch.setBrand("RATP");
		fetch.setAdjective("grève");
		fetch.setLastFetchDate(new LocalDate());
		fetch.setLastId(1234L);
		fetchService.save(fetch);
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
        	System.out.println(each);
            if (!each.startsWith("system")) {
                dbManager.getDB().getCollection(each).drop();
            }
        }

        dbManager.getDB().dropDatabase();
    }
	
	@Override
	public void testFindById() throws Exception {
		// TODO Auto-generated method stub
		fail();
	}

	@Test
	public void testFindAll() throws Exception {
		ArrayList<Fetch> all = (ArrayList<Fetch>) fetchService.findAll();
		assertEquals(1, all.size());
	}

	@Override
	public void testSave() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetFetchesWithBrandAndAdjective() throws Exception {
		Fetch fetch = new Fetch();
		fetch.setAdjective("retard");
		fetch.setBrand("APPLE");
		fetch.setLastFetchDate(new LocalDate());
		fetch.setLastId(1L);
		fetchService.save(fetch);
		
		ArrayList<Fetch> fetchedFetches = (ArrayList<Fetch>) fetchService.getFetchesWithBrandAndAdjective("APPLE", "retard");
		assertEquals(1, fetchedFetches.size());
		
		ArrayList<Fetch> fetches = (ArrayList<Fetch>) fetchService.getFetchesWithBrandAndAdjective("BRAND", "rien");
		assertEquals(0, fetches.size());
	}

}
