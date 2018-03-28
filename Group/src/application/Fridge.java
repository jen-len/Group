package application;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



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
			suggestions.add("\na glass of milk");
			if(e.contains("chicken"))
			{
				suggestions.add("\npour the milk on the chicken 4Head");
			}			
		}
		
		// eggs branch
		if(e.contains("eggs"))
		{
			suggestions.add("\nfry some eggs");
			if(e.contains("mayonnaise"))
			{
				suggestions.add("\negg salad");
			}
		}
		// chicken branch
		if(e.contains("chicken"))
		{
			suggestions.add("\neat the chicken RAW SwiftRage");
		}
		if (suggestions.size() == 0)
		{
			suggestions.add("a trip to the grocery store");
		}
		Set<String> hs = new HashSet<String>();
		hs.addAll(suggestions);
		suggestions.clear();
		suggestions.addAll(hs);
		
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
	public String normText(ArrayList<String> e)
	{
		String normie = e.toString().replace("[","").replace("]","").replace(",", "");
		return normie;
	}
	
		
}
	