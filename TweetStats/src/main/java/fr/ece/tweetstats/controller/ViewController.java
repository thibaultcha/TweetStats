package fr.ece.tweetstats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.serviceapi.FetchService;

@Controller
public class ViewController {

	@Autowired
	private FetchService fetchService;
	
	public ViewController() {
		
	}
	
	public void saveFetch(Fetch fetch) {
		fetchService.save(fetch);
	}
}
