package fr.ece.tweetstats.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.naming.ldap.Control;
import javax.swing.SwingUtilities;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.ece.tweetstats.controller.ViewController;
import fr.ece.tweetstats.core.domain.Fetch;
import fr.ece.tweetstats.core.domain.Tweet;
import fr.ece.tweetstats.core.serviceapi.FetchService;
import fr.ece.tweetstats.core.serviceimpl.FetchServiceImpl;
import fr.ece.tweetstats.twitterapi.TweetDateComparator;
import fr.ece.tweetstats.twitterapi.TweetIdComparator;
import fr.ece.tweetstats.twitterapi.TwitterAPI;

@Component
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Main p = context.getBean(Main.class);
        p.start(args);
    }

    @Autowired
    private ViewController controller;
    private void start(String[] args) {
    	Fetch fetch = new Fetch();
    	fetch.setAdjective("retard");
    	fetch.setBrand("ALLORESTO");
    	fetch.setLastFetchDate(new LocalDate());
    	fetch.setLastId(1234L);
    	controller.saveFetch(fetch);
        //System.out.println("my beans method: " + myBean.getStr());
    }
   
}

