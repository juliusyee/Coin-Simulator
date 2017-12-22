// Name: Julius Yee
// USC NetID: 2037-8984-92
// CS 455 PA1
// Fall 2017

/**
 * class CoinSimViewer
 * 
 * Contains the main program
 * First, it prompts the user for a valid input for number
 * of trials (input > 0)
 * A JFrame is created to display the bar graph by adding a
 * CoinSimComponent object to it.
 */

import javax.swing.JFrame;
import java.util.Scanner;

public class CoinSimViewer
{
	public static void main(String[] args)
	{
		//Prompt the user for an input for the number of trials and error check to ensure it is valid (>0)
		Scanner in = new Scanner(System.in);
		int input;
		do
		{
			System.out.print("Enter number of trials: ");
			input = in.nextInt();

			if (input <= 0)
			{
				System.out.println("ERROR: Number entered must be greater than 0.");
			}
		}
		while (input <= 0);
		in.close();
		
		//Create the JFrame containing the CoinSimComponent
		JFrame frame = new JFrame();
		int frameWidth = 500;
		int frameHeight = 800;
		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create the CoinSimComponent Object
		CoinSimComponent component = new CoinSimComponent(input,frame);
		frame.add(component);
		
		frame.setVisible(true);
	}
}