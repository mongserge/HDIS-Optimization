package hdis;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	
		// INPUT parameters:
		
		// Number of people.
		int peopleCount = 15;
		
		// Food priorities.
		List<FoodVote> foodVotes = new ArrayList<FoodVote>();
		foodVotes.add(new FoodVote(FoodType.ASIAN_1, 14));
		foodVotes.add(new FoodVote(FoodType.AMERICAN_2, 7));
		foodVotes.add(new FoodVote(FoodType.VODKA_BAR, 3));
		
		// Routes.
		List<Route> routesList = new ArrayList<Route>();
		Cinema cinema1 = new Cinema(1, "ISB MAX Saal");
		Cinema cinema2 = new Cinema(2, "Cinematex");
		Establishment restaurant1 = new Establishment(1, "S1", FoodType.ASIAN_1);
		Establishment restaurant2 = new Establishment(2, "S2", FoodType.AMERICAN_2);
		Establishment bar3 = new Establishment(3, "S3", FoodType.VODKA_BAR);
		
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
	}
}
