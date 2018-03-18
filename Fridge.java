// this was a work in progress it was implemented mostly for the dairy milk loop
package application;

public class Fridge 
{
	private String what; 
	int counter =0;
	
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
		counter ++;
	}
	public int getCounter()
	{
		return counter;
	}
	

}
