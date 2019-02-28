/**
 * @author Camby Abell
 * @assignment assg7_Abell
 * @filename FlightMap.java
 */

package assg7_Abell;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FlightMap implements FlightMapInterface 
{
	private LinkedList<City> cityList;
	private LinkedList<LinkedList<City>> flightList;
	
	/**
	 * Creates an empty FlightMap
	 */
	public FlightMap() 
	{
		cityList = new LinkedList<City>();
		flightList = new LinkedList<LinkedList<City>>();
	}
	
	/**
	 * Retrieves information about the cities and adjacencies from the two
	 * files provided and stores the information in the FlightMap object.
	 * @param cityFileName The name of a file containing a list of city names; 
	 *        one city name per line.
	 * @param flightFileName The name of a file showing city adjacencies.  
	 *        There will be two city names listed per line, separated by a tab
	 *        character; the first city on the line is adjacent to the 
	 *        second city on the same line.
	 * @throws FileNotFoundException if either the city file or the flight
	 *         file are not able to be opened.
	 */
	public void loadFlightMap(String cityFileName, String flightFileName) throws FileNotFoundException 
	{ 
		Scanner cReader = new Scanner(new File(cityFileName));

		if(cReader.hasNext())
		{
			while(cReader.hasNext())
			{
				String tempString = cReader.next();
				City tempCity = new City(tempString);
				cityList.add(tempCity);
			}
			cReader.close();
		}
		else
		{
			cReader.close();
			throw new FileNotFoundException();
		}
		
		Scanner fReader = new Scanner(new File(flightFileName));
		
		if(fReader.hasNext())
		{
			while(fReader.hasNext())
			{
				City temp1 = new City(fReader.next());
				City temp2 = new City(fReader.next());
				insertAdjacent(temp1, temp2);
			}
			fReader.close();
		}
		else
		{
			fReader.close();
			throw new FileNotFoundException();
		}
	}

	/**
	 * Inserts information into the flight map to record the fact that there
	 * is a direct flight between aCity and adjCity. Both aCity and adjCity
	 * are assumed to be valid cities that are served by the airline.
	 * @param aCity The origin city.
	 * @param adjCity The destination city.
	 */
	public void insertAdjacent(City aCity, City adjCity) 
	{
		LinkedList<City> tempList = new LinkedList<City>();
		tempList.add(aCity);
		tempList.add(adjCity);
		flightList.add(tempList);
	}

	/**
	 * Displays to the screen, a list of all cities served by the airline
	 * along with the names of cities to which each is adjacent.
	 */
	public void displayFlightMap() 
	{
		System.out.println("List of cities served:");
		for(int i = 0; i < cityList.size(); i++)
		{
			System.out.println(cityList.get(i));
		}
		
		System.out.println("\nList of adjacent cities:");
		for(int i = 0; i < flightList.size(); i++)
		{
			System.out.println(flightList.get(i));
		}
	}

	/**
	 * Displays to the screen, the names of all cities served by the airline.
	 */
	public void displayAllCities() 
	{
		System.out.println("List of cities served:");
		for(int i = 0; i < cityList.size(); i++)
		{
			System.out.println(cityList.get(i));
		}
	}

	/**
	 * Displays to the screen, the names of all cities which are are adjacent
	 * to aCity; aCity is assumed to be a valid city served by the airline.
	 * @param aCity The city for which the adjacency list is desired.
	 */
	public void displayAdjacentCities(City aCity) 
	{
		for(int i = 0; i < flightList.size(); i++)
		{
			City temp1 = new City(flightList.get(i).get(0).getName());
			City temp2 = new City(flightList.get(i).get(1).getName());

			if(temp1.getName().compareTo(aCity.getName()) == 0)
			{
				System.out.println("City " + aCity.getName() + " adjacent to: " + temp2.getName());
			}
			else if(temp2.getName().compareTo(aCity.getName()) == 0)
			{
				System.out.println("City " + aCity.getName() + " adjacent to: " + temp1.getName());

			}
		}
	}

	/**
	 * Records information to note that aCity has been visited in the path 
	 * so that aCity won't be returned again; aCity is assumed to be 
	 * a valid city served by the airline.
	 * @param aCity The city to be marked.
	 */
	public void markVisited(City aCity) 
	{
		for(int i = 0; i < flightList.size(); i++)
		{
			City temp1 = new City(flightList.get(i).get(0).getName());
			City temp2 = new City(flightList.get(i).get(1).getName());
			
			if(temp1.getName().compareTo(aCity.getName()) == 0)
			{
				temp1.visit();
			}
			else if(temp2.getName().compareTo(aCity.getName()) == 0)
			{
				temp2.visit();
			}
		}
	}

	/**
	 * Removes the visited marks on all cities served by the airline.
	 */
	public void unVisitAll() 
	{
		for(int i = 0; i < flightList.size(); i++)
		{
			City temp1 = new City(flightList.get(i).get(0).getName());
			City temp2 = new City(flightList.get(i).get(1).getName());
			temp1.clear();
			temp2.clear();
		}
	}

	/**
	 * Determines whether or not aCity has been visited
	 * @param aCity The city for which you wish to determine visited status.
	 * @return True if aCity has been visited, and false otherwise.
	 */
	public boolean isVisited(City aCity) 
	{
		for(int i = 0; i < flightList.size(); i++)
		{
			City temp1 = flightList.get(i).get(0);
			City temp2 = flightList.get(i).get(1);
			
			if(temp1.equals(aCity))
			{
				return temp1.isVisited();
			}
			else if(temp2.equals(aCity))
			{
				return temp2.isVisited();
			}
		}
		return false;
	}

	/**
	 * Gets the next unvisited city, if any, to which aCity is adjacent.
	 * @param aCity The city for which you wish to get the next adjacency.
	 * @return The next unvisited city to which you can directly travel
	 *         from aCity, or null there are no unvisited cities to which
	 *         you can travel from aCity.
	 */
	public City getNextCity(City aCity) 
	{
		for(int i = 0; i < flightList.size(); i++)
		{
			City temp1 = flightList.get(i).get(0);
			City temp2 = flightList.get(i).get(1);
			
			if(temp1.equals(aCity) && this.isVisited(temp2) == false)
			{
				return temp2;
			}
		}
		return null;
	}

	/**
	 * Determines if the airline serves aCity
	 * @param aCity The city to check
	 * @return True if the airline has flights leaving or arriving at
	 *         aCity and false otherwise
	 */
	public boolean servesCity(City aCity) 
	{
		for(int i = 0; i < flightList.size(); i++)
		{
			City temp1 = new City(flightList.get(i).get(0).getName());
			City temp2 = new City(flightList.get(i).get(1).getName());
			
			if(temp1.equals(aCity) || temp2.equals(aCity))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Determines if there is a sequence of flights which start at originCity,
	 * and take you to destinationCity; Both originCity and destinationCity are
	 * assumed to be valid cities served by the airline.
	 * @param originCity The city from which the search should begin
	 * @param destinationCity The final city at which you wish to arrive
	 * @return A LinkedList object containing a list of cities starting at the
	 *         originCity and ending at destinationCity, if there is a sequence 
	 *         of flights from originCity to destinationCity. The
	 *         originCity will be found in position 0 of the list.
	 *         If no sequence of flights exist, then null will be returned.
	 */
	public LinkedList<City> getPath(City originCity, City destinationCity) 
	{
		/*
		 * I copied this method out of the book and I am still getting an infinite loop.
		 * I am unsure why and have tried everything I can think of.
		 */
		
		Stack<City> cityStack = new Stack<City>();
		LinkedList<City> path = new LinkedList<City>();
		City topCity, nextCity;
		
		unVisitAll();
		
		cityStack.push(originCity);
		markVisited(originCity);
		path.add(originCity);
		
		topCity = (City) cityStack.peek();
		
		while(!cityStack.isEmpty() && !topCity.getName().equals(destinationCity.getName()))
		{
			nextCity = getNextCity(topCity);

			if(nextCity == null)
			{
				cityStack.pop();
				path.removeLast();
			}
			else
			{
				cityStack.push(nextCity);
				markVisited(nextCity);
				path.add(nextCity);
			}
			topCity = (City) cityStack.peek();
		}
		if(cityStack.isEmpty())
		{
			return null;
		}
		else
		{
			return path;
		}
	}
}
