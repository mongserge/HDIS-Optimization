package hdis;

public enum FoodType {
	ASIAN_1     (FoodCategory.ASIAN_FOOD),
	ASIAN_2     (FoodCategory.ASIAN_FOOD),
	AMERICAN_1  (FoodCategory.AMERICAN_FOOD),
	AMERICAN_2  (FoodCategory.AMERICAN_FOOD),
	EUROPEAN_1  (FoodCategory.EUROPEAN_FOOD),
	EUROPEAN_2  (FoodCategory.EUROPEAN_FOOD),
	VODKA_BAR (FoodCategory.BAR);
	
	/**
	 * Parent food category.
	 */
	private FoodCategory foodCategory;	
	
	private FoodType(FoodCategory foodType) {
		this.foodCategory = foodType;
	}

	public FoodCategory getFoodType() {
		return this.foodCategory;
	}
}
