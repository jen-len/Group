// this was a work in progress it was implemented mostly for the dairy milk loop
package application;

public class Fridge 
{
	private String what; 
	int counter =0;
	private String[] stuff = new String[3];
	
	public Fridge()
	{
		
	}
	
	public String getWhat()
	{
		return what;
	}
	public void setWhat(String what)
	{
		this.what = what;
		stuff[counter]=what;
		if(counter > 3)
		{
			
		}
		counter ++;
	}
	public int getCounter()
	{
		return counter;
	}
	
	public String[] getStuff()
	{
		return this.stuff;
	}
	


}
