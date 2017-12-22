// Name: Julius Yee
// USC NetID: 2037-8984-92
// CS 455 PA1
// Fall 2017

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;

public class CoinTossSimulator 
{
	private int numTwoHeads;
	private int numTwoTails;
	private int numHeadTails;
	private static final int HEADS = 1;
	private static final int TAILS = 0;
	private Random generator;

   /**
    * Constructor
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() 
   {
	   numTwoHeads = 0;
	   numTwoTails = 0;
	   numHeadTails = 0;
	   generator = new Random();
   }

   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) 
   {
	   int coinOne, coinTwo;
	   
	   for (int counter = 0; counter < numTrials; counter++)
	   {
		   coinOne = generator.nextInt(2);
		   coinTwo = generator.nextInt(2);
		   
		   if (((coinOne == HEADS) && (coinTwo == HEADS )) || ((coinTwo == HEADS) && (coinOne == HEADS )))
		   {
			   numTwoHeads++;
		   }
		   else if (((coinOne == TAILS) && (coinTwo == TAILS )) || ((coinTwo == TAILS) && (coinOne == TAILS )))
		   {
			   numTwoTails++;
		   }
		   else //otherwise one coin is head, the other tails
		   {
			   numHeadTails++;
		   }
	   }
   }


   /**
      Get number of trials performed since last reset.
      @return the total number of trials done
   */
   public int getNumTrials() 
   {
       return numTwoHeads + numTwoTails + numHeadTails; 
   }


   /**
      Get number of trials that came up two heads since last reset.
      @return the number of times two heads have occurred in a trial
   */
   public int getTwoHeads() 
   {
       return numTwoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
     @return the number of times two tails have occurred in a trial
   */  
   public int getTwoTails() 
   {
       return numTwoTails;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
     @return the number of times one head and one tails have occurred in a trial
   */
   public int getHeadTails() 
   {
       return numHeadTails;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() 
   {
	   numTwoHeads = 0;
	   numTwoTails = 0;
	   numHeadTails = 0;
   }

}