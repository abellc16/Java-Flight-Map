/**
 * @author Camby Abell
 * @assignment assg7_Abell
 * @filename DeterminePaths.java
 */

package assg7_Abell;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

import assg7_Abell.FlightMap;

public class DeterminePaths extends FlightMap
{
	public static void main(String args[]) 
	{
		FlightMap fMap = new FlightMap();

		try
		{
			fMap.loadFlightMap("cityFile.txt", "flightFile.txt");
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
		
		try
		{
			Scanner rReader = new Scanner(new File("requestFile.txt"));
			
			while(rReader.hasNext())
			{
				City city1 = new City(rReader.next());
				City city2 = new City(rReader.next());
				LinkedList<City> path = fMap.getPath(city1, city2);
				if(path != null)
				{
					System.out.println("Path found.");
				}
				else
				{
					System.out.println("Path not found");
				}
			}
			rReader.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.print(e);
		}
	}
}
