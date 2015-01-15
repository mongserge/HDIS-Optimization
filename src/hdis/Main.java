package hdis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

	private static HashMap<Integer, Integer> scoredEstablishments = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		// INPUT parameters:

		// Number of people.
		int peopleCount = 15;

		// Food priorities.
		List<FoodVote> foodVotes = new ArrayList<FoodVote>();
		foodVotes.add(new FoodVote(FoodType.ASIAN_1, 14));
		foodVotes.add(new FoodVote(FoodType.AMERICAN_2, 7));
		foodVotes.add(new FoodVote(FoodType.VODKA_BAR, 3));

		// Establishments
		List<Establishment> establishments = new ArrayList<Establishment>();
		Establishment restaurant1 = new Establishment(1, "S1", FoodType.ASIAN_1);
		Establishment restaurant2 = new Establishment(2, "S2", FoodType.AMERICAN_2);
		Establishment bar3 = new Establishment(3, "S3", FoodType.VODKA_BAR);

		establishments.add(restaurant1);
		establishments.add(restaurant2);
		establishments.add(bar3);

		// Routes.
		List<Route> routesList = new ArrayList<Route>();
		Cinema cinema1 = new Cinema(1, "ISB MAX Saal");
		Cinema cinema2 = new Cinema(2, "Cinematex");

		Route r1 = new Route(0, cinema1, restaurant1, 400);
		r1.addConnection(ConnectionType.BUS, "M45", 10);
		r1.addConnection(ConnectionType.BUS, "M55", 20);
		routesList.add(r1);

		Route r2 = new Route(1, cinema1, restaurant2, 200);
		r2.addConnection(ConnectionType.BUS, "M45", 10);
		r2.addConnection(ConnectionType.BUS, "M55", 20);
		routesList.add(r2);

		Route r3 = new Route(2, cinema1, bar3, 50);
		r3.addConnection(ConnectionType.BUS, "M15", 10);
		r3.addConnection(ConnectionType.UBAHN, "U2", 25);
		routesList.add(r3);

		Route r4 = new Route(3, cinema2, restaurant2, 500);
		r4.addConnection(ConnectionType.TRAM, "T1", 30);
		routesList.add(r4);

		// Optimization Parameters.
		OptimizationParams optimizationParams = new OptimizationParams(peopleCount, foodVotes);
		optimizationParams.setWeatherType(WeatherType.BAD);

		// Optimization
		// TODO: Write optimization
		// optimize(routes, optimizationParams);
		RouteOptimization routeOptimizer = new RouteOptimization(routesList, optimizationParams);
		//System.out.println(optimizer.getWalkingPenalty(450));
		routeOptimizer.getOptimalRoutes();
		scoreEstablishments(foodVotes, establishments, optimizationParams);
	}

	/**
	 * Given a list of user votes, a list of establishments, and optimization parameters, this method maps each
	 * establishment ID to an integer score based on voting results.
	 * @param foodVotes List of food votes collected from users
	 * @param establishments List of establishments available for selection
	 * @param params System optimization parameters
	 */
	private static void scoreEstablishments(List<FoodVote> foodVotes, List<Establishment> establishments, OptimizationParams params){
		HashMap<FoodType, Integer> scoredTypes = new HashMap<FoodType, Integer>();
		int foodTypeScore;

		//Get score for each food type based on votes
		for (FoodVote vote : foodVotes) {
			foodTypeScore = params.getPeopleCount() - vote.getVotesCount();
			scoredTypes.put(vote.getFoodType(), foodTypeScore);
		}

		//Match each establishment with the score assigned to its matching type (Assumes single type)
		for (Establishment establishment : establishments) {
			scoredEstablishments.put(establishment.getID(), scoredTypes.get(establishment.getType()));
		}
	}

}
