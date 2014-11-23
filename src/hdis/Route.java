package hdis;

import java.util.ArrayList;
import java.util.List;

public class Route {

	private int ID;
	private Cinema cinema;
	private Establishment establishment;
	private double walkingDistance;
	private List<Connection> connections;

	public Route(int ID, Cinema cinema, Establishment establishment, double walkingDistance) {
		this.ID = ID;
		this.cinema = cinema;
		this.establishment = establishment;
		this.walkingDistance = walkingDistance;
		this.connections = new ArrayList<Connection>();
	}

	public void addConnection(Connection connection) {
		this.connections.add(connection);
	}
	
	public void addConnection(ConnectionType type, String name, double travelTime) {
		Connection con = new Connection(type, name, travelTime);
		this.connections.add(con);
	}

	public int getNumberOfChanges() {
		return this.connections.size();
	}

	public double getTravelTimeTotal() {
		double travelTime = 0;
		for (Connection con : this.connections) {
			travelTime = travelTime + con.getTravelTime();
		}

		return travelTime;
	}

	public double getTravelTimeIn(ConnectionType type) {
		double travelTime = 0;
		for (Connection con : this.connections) {
			if (con.getType() == type) {
				travelTime = travelTime + con.getTravelTime();
			}
		}

		return travelTime;
	}

	public int getID() {
		return ID;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public Establishment getEstablishment() {
		return establishment;
	}
	
	public FoodType getEstablishmentType() {
		return establishment.getType();
	}

	public double getWalkingDistance() {
		return walkingDistance;
	}
}
