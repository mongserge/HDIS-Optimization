package hdis;

public class Establishment {
	
	private int ID;
	private String name;
	private FoodType type;
	
	public Establishment(int ID, String name, FoodType type) {
		this.ID = ID;
		this.name = name;
		this.type = type;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public FoodType getType() {
		return type;
	}
}
