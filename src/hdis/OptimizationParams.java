package hdis;

import java.util.List;

public class OptimizationParams {

	// Number of people in the group
	private int peopleCount;

	// Priority of Food
	List<FoodVote> foodVotes;

	// Walking Distance
	public static final double DEFAULT_WALKING_DISTANCE_MAX = 500;
	public static final double DEFAULT_WALKING_DISTANCE_L1 = 0.3;
	public static final double DEFAULT_WALKING_DISTANCE_L2 = 0.8;
	public static final double DEFAULT_WALKING_DISTANCE_L3 = 1.0;
	public static final double DEFAULT_WALKING_PENALTY_DL1 = 1.5;
	public static final double DEFAULT_WALKING_PENALTY_DL2 = 1.75;
	public static final double DEFAULT_WALKING_PENALTY_DL3 = 3.0;

	private double walkingDistanceMax = DEFAULT_WALKING_DISTANCE_MAX;
	private double walkingDistanceL1 = DEFAULT_WALKING_DISTANCE_L1;
	private double walkingDistanceL2 = DEFAULT_WALKING_DISTANCE_L2;
	private double walkingDistanceL3 = DEFAULT_WALKING_DISTANCE_L3;
	private double walkingPenaltyDL1 = DEFAULT_WALKING_PENALTY_DL1;
	private double walkingPenaltyDL2 = DEFAULT_WALKING_PENALTY_DL2;
	private double walkingPenaltyDL3 = DEFAULT_WALKING_PENALTY_DL3;

	// Weather
	public static WeatherType DEFAULT_WEATHER_TYPE = WeatherType.GOOD;
	public static double DEFAULT_WEATHER_GOOD_EXTRA_PENALTY = 1.0;
	public static double DEFAULT_WEATHER_MEDIUM_EXTRA_PENALTY = 1.25;
	public static double DEFAULT_WEATHER_BAD_EXTRA_PENALTY = 1.5;

	private WeatherType weatherType = DEFAULT_WEATHER_TYPE;
	private double weatherGoodExtraPenalty = DEFAULT_WEATHER_GOOD_EXTRA_PENALTY;
	private double weatherMediumExtraPenalty = DEFAULT_WEATHER_MEDIUM_EXTRA_PENALTY;
	private double weatherBadExtraPenalty = DEFAULT_WEATHER_BAD_EXTRA_PENALTY;

	public OptimizationParams(int peopleCount, List<FoodVote> foodVotes) {
		this.peopleCount = peopleCount;
		this.foodVotes = foodVotes;
	}
	
	public int getPeopleCount() {
		return peopleCount;
	}

	public List<FoodVote> getFoodVotes() {
		return foodVotes;
	}

	public double getWalkingDistanceMax() {
		return walkingDistanceMax;
	}

	public void setWalkingDistanceMax(double walkingDistanceMax) {
		this.walkingDistanceMax = walkingDistanceMax;
	}

	public double getWalkingDistanceL1() {
		return walkingDistanceL1;
	}

	public void setWalkingDistanceL1(double walkingDistanceL1) {
		this.walkingDistanceL1 = walkingDistanceL1;
	}

	public double getWalkingDistanceL2() {
		return walkingDistanceL2;
	}

	public void setWalkingDistanceL2(double walkingDistanceL2) {
		this.walkingDistanceL2 = walkingDistanceL2;
	}

	public double getWalkingDistanceL3() {
		return walkingDistanceL3;
	}

	public void setWalkingDistanceL3(double walkingDistanceL3) {
		this.walkingDistanceL3 = walkingDistanceL3;
	}

	public double getWalkingPenaltyDL1() {
		return walkingPenaltyDL1;
	}

	public void setWalkingPenaltyDL1(double walkingPenaltyDL1) {
		this.walkingPenaltyDL1 = walkingPenaltyDL1;
	}

	public double getWalkingPenaltyDL2() {
		return walkingPenaltyDL2;
	}

	public void setWalkingPenaltyDL2(double walkingPenaltyDL2) {
		this.walkingPenaltyDL2 = walkingPenaltyDL2;
	}

	public double getWalkingPenaltyDL3() {
		return walkingPenaltyDL3;
	}

	public void setWalkingPenaltyDL3(double walkingPenaltyDL3) {
		this.walkingPenaltyDL3 = walkingPenaltyDL3;
	}

	public WeatherType getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(WeatherType weatherType) {
		this.weatherType = weatherType;
	}

	public double getWeatherGoodExtraPenalty() {
		return weatherGoodExtraPenalty;
	}

	public void setWeatherGoodExtraPenalty(double weatherGoodExtraPenalty) {
		this.weatherGoodExtraPenalty = weatherGoodExtraPenalty;
	}

	public double getWeatherMediumExtraPenalty() {
		return weatherMediumExtraPenalty;
	}

	public void setWeatherMediumExtraPenalty(double weatherMediumExtraPenalty) {
		this.weatherMediumExtraPenalty = weatherMediumExtraPenalty;
	}

	public double getWeatherBadExtraPenalty() {
		return weatherBadExtraPenalty;
	}

	public void setWeatherBadExtraPenalty(double weatherBadExtraPenalty) {
		this.weatherBadExtraPenalty = weatherBadExtraPenalty;
	}

}
