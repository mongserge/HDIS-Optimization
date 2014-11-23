package hdis;

public class Connection {

	private ConnectionType type;
	private String name;
	private double travelTime;
	
	public Connection(ConnectionType type, String name, double travelTime) {
		this.type = type;
		this.name = name;
		this.travelTime = travelTime;
	}

	public ConnectionType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public double getTravelTime() {
		return travelTime;
	}
}
