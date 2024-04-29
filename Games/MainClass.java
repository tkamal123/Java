import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class MainClass
{
	private static GameSuperclass game;

	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		DiceRoller roller;
		HigherOrLower higherOrLower;
		Hangman hangman;



		System.out.println("Welcome to the Game Lounge! Please pick your game: ");
		System.out.println("1. Dice Roller\r\n"
				+ "2. Higher or Lower\r\n"
				+ "3. Hangman");
		//user picks the game number 
		int pickGameNumber = scan.nextInt();
		//if user picks one DiceRoller class will run
		if (pickGameNumber==1) {
			//calling the object 
			roller = new DiceRoller("diceroller");
			//printing the gameIntro
			roller.printGameIntro();
			//user input for how many dice rolls;
			int userInput = scan.nextInt();
			roller.processInput(userInput);
		}
		//if user picked 2 HigherorLower class will run
		else if (pickGameNumber==2) {
			//initial value = false
			boolean ok = false;

			Random random = new Random();
			//randomNumber range number between 0 to 100
			int randomNumber = random.nextInt(100);
			//calling the object
			higherOrLower= new HigherOrLower("higherOrLower",randomNumber );

			//prints gameIntro
			higherOrLower.printGameIntro();
			System.out.println("Please input your first guess: ");

			//while look that stops when ok == false

			do {

				//user inputs the value and processInput object is called 
				int userGuess = scan.nextInt();
				higherOrLower.processInput(userGuess );

			}while(ok == false); 

		}
		else  {
			//calls out hangman method game
			hangman= new Hangman();
			hangman.printGameIntro();
			hangman.processInput();

		}

	}
	
}


	//All your user input code should go in main
	//Including looping until the game selected
	//tells you that it is complete via the return
	//value of the relevant method.



	//You need to complete this method - you can comment it out
	//until you need it!
	//	private static boolean () {
	//	try {

	//	}
	//	catch {

	//	}
	//}



