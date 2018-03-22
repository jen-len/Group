package application;

import java.util.ArrayList;

public class Fridge 
{
	private String what; 
	int counter =0;
	
	public Fridge()
	{
		
	}

	public void findRecipe(ArrayList<String> e)
	{		
		// OBVIOUSLY this could be a shit load more organized
		// like each thing would have its own decision trees, would be time consuming but easy
		// but not that bad because if all you have is milk + carrots, there isn't much you could make
		// unless of course you guys want to go stupid complicated
		// milk branch
		if(e.contains("milk"))
		{
			if(e.contains("chicken"))
			{
				System.out.println("pour the milk on the chicken 4Head");
				return;
			}
			
			System.out.println("have a glass of milk");
			return;
			
		}
		// chicken branch
		if(e.contains("chicken"))
		{
			System.out.println("eat the chicken");
			return;
		}
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
	
	
	

}