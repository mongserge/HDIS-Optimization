package hdis;

public class FoodVote {

	private FoodType foodType;
	private int votesCount;

	public FoodVote(FoodType foodType, int votesCount) {
		this.foodType = foodType;
		this.votesCount = votesCount;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public int getVotesCount() {
		return votesCount;
	}
}
