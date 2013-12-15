package fr.ece.tweetstats.controler;

import java.util.List;
import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.serviceapi.FetchService;
import fr.ece.tweetstats.core.serviceapi.FetchServiceTestBase;
import fr.ece.tweetstats.twitterapi.TwitterAPI;

public class TweetstatsController {
	
	public TweetstatsController() {
		
	}
	// perform fetches and save them in mongodb
	public List<Fetch> doFetchAndSave() {
		
		// MONGO : mongo.fetchByBrandAndAdj(brand, adj) 
		// null ou fetch
		// if (fetch) getByFetch(fetch)
		// if (!fetch) TwitterAPI.getByiuegfirelg(brand, ezfihu, uhfreilufh)
		//List<Fetch> fetches = TwitterAPI.getByiuegfirelg();

		// mongo.save(fetches)

		// update jchart
		return null;
	}

	public void updateChart() {
		// retrieve fetches
		List<Fetch> fetches = this.doFetchAndSave();


		// update chart
		for(int i = 0; i < fetches.size(); i++) {
			//fetches.get(i).adjective(); // x
			fetches.get(i).getResults().size(); // y
		}
	}
}
