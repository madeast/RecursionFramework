package recursion.view;

import javax.swing.JFrame;

import recursion.controller.RecursionController;

public class RecursionFrame extends JFrame
{
	private RecursionPanel basePanel;
	private RecursionController baseController;
	
	public RecursionFrame(RecursionController baseController)
	{
		this.baseController = baseController;
		basePanel = new RecursionPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Lets recures");
		this.setSize(500, 500);
		this.setVisible(true);
	}
}
