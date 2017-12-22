// Name: Julius Yee
// USC NetID: 2037-8984-92
// CS 455 PA1
// Fall 2017

/**
 * class CoinSimComponent
 * 
 * Runs the simulation using the CoinTossSimulator class 
 * and creates the bar graph using the Bar class.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class CoinSimComponent extends JComponent
{
	private static final Color HEAD_HEAD_COLOR = Color.RED;
	private static final Color HEAD_TAIL_COLOR = Color.BLACK;
	private static final Color TAIL_TAIL_COLOR = Color.BLUE;
	private static final int BAR_WIDTH = 100;
	private static final int VERTICAL_BUFFER = 200;
	private int numberOfTrials;
	private int windowWidth;
	private int windowHeight;
	private CoinTossSimulator simulator;
	private JFrame display;
	
	
	/**
	    * Constructor
	    * Creates a CoinSimComponent.  You give number of trials that are ran and 
	  	*the JFrame window that will be displayed.
	      @param trials the number of trials (times 2 coins have been flipped) 
	      @param window the window that present the results of the simulation 
	      		 in the form of a bar graph
	*/
	public CoinSimComponent(int trials, JFrame window)
	{
		//Initialize the instance variables
		numberOfTrials = trials;
		display = window;
		windowWidth = window.getWidth();
		windowHeight = window.getHeight();
		
		//Run the simulation "trials" number of times
		simulator = new CoinTossSimulator();
		simulator.run(numberOfTrials);
	}
	
	/**
	     * Puts together the bars and bar labels to construct the bar graph
	  
	      @param g a Graphics object for all graphics context to draw components
	*/
	public void paintComponent(Graphics g)
	{	
		//Every time paintComponent is called again, update the current size of the window 
		//This allows the bar graph to adjust to the size of the window if it gets resized
		windowWidth = display.getWidth();
		windowHeight = display.getHeight();
		
		//Use the results of the simulation to calculate the % of each result
		double twoHeadsPercentage = Math.round(((double)simulator.getTwoHeads()/(double)simulator.getNumTrials()) * 100.0);
		double twoTailsPercentage = Math.round(((double)simulator.getTwoTails()/(double)simulator.getNumTrials()) * 100.0);
		double oneEachPercentage = Math.round(((double)simulator.getHeadTails()/(double)simulator.getNumTrials()) * 100.0);
				
		//Calculate the width between each bar, application unit, and starting y coordinate of top left corner of a heightless bar
		int widthBetweenBars = (windowWidth - (3*BAR_WIDTH))/4;
		double applicationUnitHeight = (double)(windowHeight - (2 * VERTICAL_BUFFER))/(double)(numberOfTrials);
		int startY = windowHeight - VERTICAL_BUFFER;
		
		//Put together the bar labels into a string in the proper format
		String twoHeadsLabel = "Two Heads:" + String.valueOf(simulator.getTwoHeads()) + " \"" + String.valueOf(twoHeadsPercentage) + "%\"";
		String headTailsLabel = "A Head and a Tail:" + String.valueOf(simulator.getHeadTails()) + " \"" + String.valueOf(oneEachPercentage) + "%\"";
		String twoTailsLabel = "Two Tails:" + String.valueOf(simulator.getTwoTails()) + " \"" + String.valueOf(twoTailsPercentage) + "%\"";
		
		//Calculate the x-coordinate of the left side of the middle and right bars
		int middleBarX = BAR_WIDTH + (2* widthBetweenBars);
		int rightBarX = (2 * BAR_WIDTH) + (3 * widthBetweenBars);
		
		//Create the 3 bar objects
		Graphics2D g2 = (Graphics2D) g;
		Bar twoHeadsData = new Bar(startY,widthBetweenBars,BAR_WIDTH,simulator.getTwoHeads(),applicationUnitHeight,HEAD_HEAD_COLOR,twoHeadsLabel);
		Bar headTailsData = new Bar(startY,middleBarX,BAR_WIDTH,simulator.getHeadTails(),applicationUnitHeight,HEAD_TAIL_COLOR, headTailsLabel);
		Bar twoTailsData = new Bar(startY,rightBarX,BAR_WIDTH,simulator.getTwoTails(),applicationUnitHeight,TAIL_TAIL_COLOR,twoTailsLabel);
		
		//Call the draw function to draw the 3 bars
		twoHeadsData.draw(g2);
		headTailsData.draw(g2);
		twoTailsData.draw(g2);
	}
}
