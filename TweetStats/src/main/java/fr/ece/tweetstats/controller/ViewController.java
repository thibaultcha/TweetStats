package fr.ece.tweetstats.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.serviceapi.FetchService;
import fr.ece.tweetstats.twitterapi.TwitterAPI;

@Component
public class ViewController {

	@Autowired
	private FetchService fetchService;
	
	public ViewController() {

	}
	
	public List<Fetch> doFetchAndSave(String brand, List<String> adjectives) {
		List<Fetch> fetches = new ArrayList<Fetch>();
		for (String adj : adjectives) {
			Fetch fetch = null;
			List<Fetch> fetchedFetches = fetchService.getFetchesWithBrandAndAdjective(brand, adj);
			if (fetchedFetches.size() > 0) {
				 fetch = TwitterAPI.getFromExistingFetch(fetchedFetches.get(0));
			}
			else {
				fetch = new Fetch();
				fetch.setBrand(brand);
				fetch.setAdjective(adj);
				fetch = TwitterAPI.getFromExistingFetch(fetch);
			}
			fetchService.save(fetch);
			fetches.add(fetch);
		}
		
		return fetches;
	}
		
}
