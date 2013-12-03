import java.awt.List;
import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import tweetstats.*;

public class Main {

	public static void main(String[] args) {
		EList<Tweet> fetch_result = new BasicEList<Tweet>();
		
		// Sample tweets
		Tweet t1 = TweetstatsFactory.eINSTANCE.createTweet();
		t1.setId(new Long(123456789));
		t1.setDate(new Date());
		t1.setMessage("This is a test tweet");
		fetch_result.add(t1);
		
		Tweet t2 = TweetstatsFactory.eINSTANCE.createTweet();
		t2.setId(new Long(234567891));
		t2.setDate(new Date());
		t2.setMessage("Second test tweet");
		fetch_result.add(t2);
		
		// Sample fetch
		Fetch fetch = TweetstatsFactory.eINSTANCE.createFetch();
		fetch.setDate(new Date());
		for (Tweet tweet : fetch_result) {
			tweet.setFetch(fetch);
		}
		Long lastId = fetch_result.get(fetch_result.size()-1).getId();
		fetch.setLast_id(lastId);
		
		// Read fetch
		System.out.println(fetch);
		for (Tweet tweet : fetch.getResults()) {
			System.out.println(tweet.toString());
		}
		
		
		// mongodb://127.0.0.1:27017/tweetstats
	}
}
