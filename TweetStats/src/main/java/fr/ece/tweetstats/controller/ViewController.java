package fr.ece.tweetstats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.serviceapi.FetchService;

@Component
public class ViewController {

	@Autowired
	private FetchService fetchService;
	
	public ViewController() {
		
	}
	
	// Méthode example! save dans mongodb (le serveur doit être lancé sur localhost:27017 (adresse par défaut)
	public void saveFetch(Fetch fetch) {
		fetchService.save(fetch);
	}
}
