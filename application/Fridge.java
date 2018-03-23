package application;


import java.util.ArrayList;



public class Fridge 
{
	private String what; 
	int counter =0;
	ArrayList<String> suggestions = new ArrayList<String>();
 
	
	public Fridge()
	{	}

	public ArrayList<String> findRecipe(ArrayList<String> e)
	{	
		// milk branch
		if(e.contains("milk"))
		{
			suggestions.add("a glass of milk\n");

			if(e.contains("chicken"))
			{
				suggestions.add("pour the milk on the chicken 4Head\n");
			}
			
			
		}
		
		// eggs branch
		if(e.contains("eggs"))
		{
			suggestions.add("fry some eggs\n");
			
			if(e.contains("mayonnaise"))
			{
				suggestions.add("egg salad\n");
			}
		}
		
		// chicken branch
		if(e.contains("chicken"))
		{
			suggestions.add("eat the chicken RAW SwiftRage\n");
			
		}
		
		if (e.size() == 0)
		{
			suggestions.add("a trip to the grocery store");
		}
		
		
		return suggestions;

	}
	
	public String getWhat()
	{
		return this.what;
	}
	public void setWhat(String what)
	{
		this.what = what;
		counter ++;
	}
	public int getCounter()
	{
		return counter;
	}
	public void setCounter(int x)
	{
		this.counter=x;
	}
	
		
}
	