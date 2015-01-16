package hdis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RouteOptimization {
	
	private List<Route> routes;
	private OptimizationParams optiParams;
	private HashMap<Integer, Double> routesWithPenalty;
	private List<Integer> optimalRoutes;
	
	public RouteOptimization(List<Route> routes,OptimizationParams optiParams) {
		this.routes = routes;
		this.optiParams = optiParams;
	}
	
	public void getOptimalRoutes()
	{
		this.routesWithPenalty = new HashMap<Integer, Double>();
		this.optimalRoutes =  new ArrayList<Integer>();
		for(Route route: this.routes)
		{
			double  totatPenalty = 0;
			totatPenalty = getTotalPenaltyForARoute(route);
			this.routesWithPenalty.put(route.getID(), totatPenalty);
		}
		
	 sortByComparator(routesWithPenalty);
	 for(int ctr = 0; ctr < 3; ctr++)
	 {
		 System.out.println(this.optimalRoutes.get(ctr));
	 }
			
	}
	
	public void sortByComparator(HashMap<Integer, Double> routesWithPenalty)
	{
		List<Entry<Integer,Double>> routeList = new LinkedList<Map.Entry<Integer,Double>>(routesWithPenalty.entrySet());
		
		 Collections.sort(routeList, new Comparator<Entry<Integer, Double>>()
			        {
			            public int compare(Entry<Integer, Double> o1,
			                    Entry<Integer, Double> o2)
			            {
			               return o1.getValue().compareTo(o2.getValue());
			            }
			        });
		 
		 Map<Integer, Double> sortedRoutes = new HashMap<Integer, Double>();
		 for(Entry<Integer, Double> entry: routeList)
		 {
			 sortedRoutes.put(entry.getKey(), entry.getValue());
			 this.optimalRoutes.add(entry.getKey());
		 }
		 
	
	}

	public double getTotalPenaltyForARoute(Route route)
	{
		double totalPenalty = getWalkingPenalty(route.getWalkingDistance()) +
				 getConnectionChangesPenalty(route);
		return totalPenalty;
	}
	
	public double getWalkingPenalty(double walkingDistance)
	{
		double walkingPenalty = 0;
		if(walkingDistance > optiParams.getWalkingDistanceMax() || walkingDistance < 0)
			System.out.println("Exception");
		else
		{
			double comfortLevel1 = 0, comfortLevel2 = 0, comfortLevel3 = 0;
			comfortLevel1 = optiParams.getWalkingDistanceL1()*optiParams.getWalkingDistanceMax();
			if(walkingDistance <= comfortLevel1)
				comfortLevel1 = walkingDistance;
			if(walkingDistance > comfortLevel1)
			{
				if(walkingDistance > optiParams.getWalkingDistanceL2()*optiParams.getWalkingDistanceMax())
					comfortLevel2 = (optiParams.getWalkingDistanceL2()*
										optiParams.getWalkingDistanceMax())	- comfortLevel1;
				else
					comfortLevel2 = walkingDistance - comfortLevel1;
				
				comfortLevel3 = walkingDistance - (comfortLevel1 + comfortLevel2);
			}
					
			walkingPenalty = ((comfortLevel1/optiParams.getWalkingSpeed())*optiParams.getWalkingPenaltyDL1()) +
						((comfortLevel2/optiParams.getWalkingSpeed())*optiParams.getWalkingPenaltyDL2()) +
						((comfortLevel3/optiParams.getWalkingSpeed())*optiParams.getWalkingPenaltyDL3());
		}
		return walkingPenalty;
	}
	
	public double getTravellingTimePenalty(Route route)
	{
		return route.getTravelTimeTotal();
	}
	
	public double getConnectionChangesPenalty(Route route)
	{
		double connectionChangesPenalty = getTravellingTimePenalty(route);
		int changes = route.getNumberOfChanges();
		
		if(changes >= 2)
		{
			for(int ctr = 2;ctr <= changes; ctr++)
			{
				if(ctr == 2)
				{
					connectionChangesPenalty = connectionChangesPenalty + 
					(optiParams.getFirstChangePenalty()*connectionChangesPenalty);
				}
				else
					connectionChangesPenalty = connectionChangesPenalty + 
					(optiParams.getSubsequentChangePenalty()*connectionChangesPenalty);
			}
		}
		return connectionChangesPenalty;
	}
}
