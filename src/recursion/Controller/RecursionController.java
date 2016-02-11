package recursion.controller;

import recursion.model.RecursionTool;
import recursion.view.RecursionFrame;

/**
 *
 * @author emad6932
 * @version 1.0
 *
 */
public class RecursionController
{
	//Variables
	private RecursionFrame baseFrame;
	private RecursionTool mathTool;
	private String calculatedValue;
	
	
	//Stuff the program will do on start.
	public void start()
	{
		calculatedValue = Integer.toString(mathTool.getFibNumber(0));
	}
	
	//Stuff that will do when RecursionController is called.
	public RecursionController()
	{
		mathTool = new RecursionTool();
		baseFrame = new RecursionFrame(this);
		
	}
	
	public String getCalculatedValue()
	{
		return calculatedValue;
	}
	
	public String doFibonacci(String inputValue)
	{
		calculatedValue = "The Fibonacci sequence number of " + inputValue + 
				" is " + Integer.toString(mathTool.getFibNumber(Integer.parseInt(inputValue)));
		
		return calculatedValue;
		
	}
	
	public String doFactorial(String inputValue)
	{
		calculatedValue = "The Factorial sequence number of " + inputValue + 
				" is " + Integer.toString(mathTool.getFactorialNumber(Integer.parseInt(inputValue)));
		
		return calculatedValue;
	}
}
