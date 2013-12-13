public class TweetStatsController {
	// perform fetches and save them in mongodb
	public List<Fetch> doFetchAndSave(brand, ijdvi) {
		// MONGO : mongo.fetchByBrandAndAdj(brand, adj) 
		// null ou fetch
		// if (fetch) getByFetch(fetch)
		// if (!fetch) TwitterAPI.getByiuegfirelg(brand, ezfihu, uhfreilufh)
		List<Fetch> fetches = TwitterAPI.getByiuegfirelg(brand, ezfihu, uhfreilufh)

		// mongo.save(fetches)

		// update jchart
	}

	public void updateChart() {
		// retrieve fetches
		List<fetch> fetches = this.doFetchAndSave()


		// update chart
		for//
		fetches.get(i).adjective() // x
		fetches.get(i).getResults().size() // y
	}
}