/**
 * @author Camby Abell
 * @assignment assg7_Abell
 * @filename City.java
 */

package assg7_Abell;

public class City 
{
	private String ctyName;
	private int v;

	/**
	 * Initializes a City with cityName and marks the
	 * City as unvisited.
	 * @param cityName The name of the city to create
	 */
	public City(String cityName) 
	{
		ctyName = cityName;
		v = 0;
	}
	
	/** 
	 * Gets the name of the City
	 * @return The city name
	 */
	public String getName()
	{
		return this.ctyName;
	}
	
	/**
	 * Determines if a City has been visited
	 * @return True if the city has been visited
	 *         and false otherwise
	 */
	public boolean isVisited() 
	{
		if(this.v == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Marks the City as having been visited
	 */
	public void visit() 
	{
		this.v = 1;
	}

	/**
	 * Clears the visited mark so the city will
	 * be marked as unvisited.
	 */
	public void clear() 
	{
		this.v = 0;
	}

	/**
	 * Overridden equals method determines if the
	 * current City name is equal to obj
	 * @param obj The object to be compared to this City
	 * @return True if this city name matches the city name
	 *         in obj, and false otherwise
	 */
	public boolean equals(Object obj) 
	{
		if(obj instanceof City)
		{
			City temp = new City(((City) obj).getName());
			
			if(this.getName().equals(temp.getName()))
			{
				return true;
			}
		}	
		return false;
	}
	
	/**
	 * Overrridden toString method
	 * @return The name of the city
	 */
	public String toString() 
	{
		return "City name: " + this.getName();
	}
}
