package fr.ece.tweetstats.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.ece.tweetstats.search.domain.Search;
import fr.ece.tweetstats.search.serviceapi.SearchService;
import fr.ece.tweetstats.view.MainView;

@Component
public class Main {
    
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Main p = context.getBean(Main.class);
        p.start(args);
    }

    @Autowired
    private MainView view;
    
    @Autowired
    private SearchService searchService;
    
	private static ApplicationContext context;
	static final Map<String , List<String>> DEFAULT_SEARCHES = new HashMap<String, List<String>>() {{
	    put("RATP",      Arrays.asList("grève", "retard", "RER", "ligne"));
	    put("Alloresto", Arrays.asList("livreur", "retard", "plat", "cher"));
	    put("M6",        Arrays.asList("patissier", "talent", "talents"));
	}};
	
	
    private void start(String[] args) {
    	for (Entry<String, List<String>> entry : DEFAULT_SEARCHES.entrySet()) {
    		Search search = new Search();
    		search.setAdjectives(entry.getValue());
    		search.setBrand(entry.getKey());
    		searchService.save(search);
    	}
    }

}
