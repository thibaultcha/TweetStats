package fr.ece.tweetstats.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

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
	private static ApplicationContext context;
    private void start(String[] args) {

    }

}

