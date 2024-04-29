import java.util.Random;
public class HigherOrLower extends GameSuperclass {
	//Attributes 
	public String gameName;
	public int randomNumber;
	//counter for the amount of guesses
	public int guess = 1;
	//Constructor
	public HigherOrLower(String gameName, int random) {

		super(gameName);
		this.randomNumber= random;
	}
	//Method 
	public void printGameIntro() {
		System.out.println("Welcome to " + super.gameName);
		System.out.println("I'm thinking of a number between 0 and 100 (inclusive)");		

	}
	@Override
	public boolean processInput( int value){

		Random random = new Random();		
		boolean finish = false;




		//if the user input is less than the random number then it prints out the number is lower guess again	
		if (value>randomNumber) {
			System.out.println("Sorry, my number is LOWER than that! Guess again: ");			
			// adds +1 to the counter 			
			guess= guess + 1;
		}
		//else if the user input is more than the random number then it prints out the number is higher guess again	

		else if (value<randomNumber) {
			System.out.println("Sorry, my number is HIGHER than that! Guess again: ");			

			guess= guess + 1;
		}
		//else prints correct and the random number. Also prints out the amount of guesses 
		else {
			System.out.print("Correct! My number was: " + (randomNumber));
			System.out.println("");
			System.out.println("You got it right in " + guess + " guesses!");
			finish = true;
		}	

		//boolean return type is finish
		return finish;


	}
}
