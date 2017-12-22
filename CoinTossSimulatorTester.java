// Name: Julius Yee
// USC NetID: 2037-8984-92
// CS 455 PA1
// Fall 2017

/**
 * class CoinTossSimulatorTester
 * 
 *Unit Tester Class for the CoinTossSimulator class
 *Contains a main function that is a console-based program to test the 
 *CoinTossSimulator class thoroughly.
 */

public class CoinTossSimulatorTester
{
	public static void main(String[] args)
	{
		CoinTossSimulator test_simulator = new CoinTossSimulator();
		
		//TEST 1
		System.out.println("After constructor: ");
		System.out.println("Number of trials [exp:0]: " + test_simulator.getNumTrials());
		System.out.println("Two-head tosses: " + test_simulator.getTwoHeads());
		System.out.println("Two-tail tosses: " + test_simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test_simulator.getHeadTails());
		if (test_simulator.getTwoHeads() + test_simulator.getTwoTails() + test_simulator.getHeadTails() == 0)
		{
			System.out.println("Tosses add up!");
		}
		else
		{
			System.out.println("ERROR, tosses do not add up!");
		}
		
		//TEST 2
		test_simulator.run(1);
		System.out.println();
		
		System.out.println("After run(1):");
		System.out.println("Number of trials [exp:1]: " + test_simulator.getNumTrials());
		System.out.println("Two-head tosses: " + test_simulator.getTwoHeads());
		System.out.println("Two-tail tosses: " + test_simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test_simulator.getHeadTails());
		if (test_simulator.getTwoHeads() + test_simulator.getTwoTails() + test_simulator.getHeadTails() == 1)
		{
			System.out.println("Tosses add up!");
		}
		else
		{
			System.out.println("ERROR, tosses do not add up!");
		}
		
		test_simulator.run(10);
		System.out.println();
		
		System.out.println("After run(10):");
		System.out.println("Number of trials [exp:11]: " + test_simulator.getNumTrials());
		System.out.println("Two-head tosses: " + test_simulator.getTwoHeads());
		System.out.println("Two-tail tosses: " + test_simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test_simulator.getHeadTails());
		if (test_simulator.getTwoHeads() + test_simulator.getTwoTails() + test_simulator.getHeadTails() == 11)
		{
			System.out.println("Tosses add up!");
		}
		else
		{
			System.out.println("ERROR, tosses do not add up!");
		}
		
		//TEST 3
		test_simulator.run(100);
		System.out.println();
		
		System.out.println("After run(100):");
		System.out.println("Number of trials [exp:111]: " + test_simulator.getNumTrials());
		System.out.println("Two-head tosses: " + test_simulator.getTwoHeads());
		System.out.println("Two-tail tosses: " + test_simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test_simulator.getHeadTails());
		if (test_simulator.getTwoHeads() + test_simulator.getTwoTails() + test_simulator.getHeadTails() == 111)
		{
			System.out.println("Tosses add up!");
		}
		else
		{
			System.out.println("ERROR, tosses do not add up!");
		}
		
		//TEST 4
		test_simulator.reset();
		System.out.println();
		
		System.out.println("After reset:");
		System.out.println("Number of trials [exp:0]: " + test_simulator.getNumTrials());
		System.out.println("Two-head tosses: " + test_simulator.getTwoHeads());
		System.out.println("Two-tail tosses: " + test_simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test_simulator.getHeadTails());
		if (test_simulator.getTwoHeads() + test_simulator.getTwoTails() + test_simulator.getHeadTails() == 0)
		{
			System.out.println("Tosses add up!");
		}
		else
		{
			System.out.println("ERROR, tosses do not add up!");
		}
		
		//TEST 5
		test_simulator.run(1000);
		System.out.println();
		
		System.out.println("After run(1000):");
		System.out.println("Number of trials [exp:1000]: " + test_simulator.getNumTrials());
		System.out.println("Two-head tosses: " + test_simulator.getTwoHeads());
		System.out.println("Two-tail tosses: " + test_simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test_simulator.getHeadTails());
		if (test_simulator.getTwoHeads() + test_simulator.getTwoTails() + test_simulator.getHeadTails() == 1000)
		{
			System.out.println("Tosses add up!");
		}
		else
		{
			System.out.println("ERROR, tosses do not add up!");
		}
	}
}