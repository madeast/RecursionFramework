package recursion.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import recursion.controller.RecursionController;

public class RecursionPanel extends JPanel
{
	private RecursionController baseController;
	private JButton fibonacciButton;
	private JButton factorialButton;
	private JTextField inputField;
	private JTextArea displayArea;
	private SpringLayout baseLayout;
	
	public RecursionPanel(RecursionController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		fibonacciButton = new JButton("Get the Fibonacci sequence for this number");
		factorialButton = new JButton("Get n!");
		inputField = new JTextField(20);
		displayArea = new JTextArea(10, 20);

		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	//Where we call all the objects that are on the panels.
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(fibonacciButton);
		this.add(factorialButton);
		this.add(inputField);
		this.add(displayArea);
		displayArea.setWrapStyleWord(true);
		displayArea.setLineWrap(true);
		displayArea.setEditable(false);
		displayArea.setText(baseController.getCalculatedValue());
	}
	
	//Where all the junk view code goes.
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, displayArea, 10, SpringLayout.SOUTH, fibonacciButton);
		baseLayout.putConstraint(SpringLayout.NORTH, factorialButton, 10, SpringLayout.SOUTH, displayArea);
		baseLayout.putConstraint(SpringLayout.WEST, displayArea, 105, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, fibonacciButton, 10, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 98, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, factorialButton, 184, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, fibonacciButton, 66, SpringLayout.WEST, this);
	}
	
	//Where we set what things do in the panel.
	private void setupListeners()
	{
		fibonacciButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userInput = inputField.getText();
				if(checkInput(userInput))
				{
					displayArea.setText(baseController.doFibonacci(userInput));
				}
			}
		});
		
		
		factorialButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userInput = inputField.getText();
				if(checkInput(userInput))
				{
					displayArea.setText(baseController.doFactorial(userInput));
				}
			}
		});
	}
	
	private boolean checkInput(String input)
	{
		boolean isNumber = false;
		
		try
		{
			Integer.parseInt(input);
			isNumber = true;
		}
		catch(Exception numberException)
		{
			displayArea.setText("Type in a number!!!!");
		}
		
		return isNumber;
	}
}
