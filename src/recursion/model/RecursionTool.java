package recursion.model;

public class RecursionTool
{

	public int getFibNumber(int position)
	{
	
		
		//Defensive code against user errors
		if(position < 0)
		{
			return Integer.MIN_VALUE;
		}
		//Base Case
		if(position == 0 || position == 1)
		{
			return 1;
		}
		
		else //Recursive Case - We must keep calling the method.
		{
			return getFibNumber(position - 1) +getFibNumber(position - 2);
		}
		
		
	}
}
