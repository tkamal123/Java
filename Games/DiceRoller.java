import java.util.Random;
public class DiceRoller extends GameSuperclass{
	//Attributes 
	public String gameName;
	// Constructor  
	public DiceRoller(String gameName) {
		//Updating the parent class (GamerSuperclass)
		super(gameName);
	}

	//Method

	public void printGameIntro() {
		//Printing the Game name 
		System.out.println("Welcome to " + super.gameName);
		System.out.println("Please input how many D6s you want to roll: ");

	}
	//Method allows a class to inherit from a superclass and then to update the code
	@Override
	public boolean processInput(int value) {
		//Created an upper bound with the max value of 6
		int upperBound=6;
		Random random = new Random();
		int range;

		System.out.println("Dice rolled: ");
		// Created a for loop where the user inputs the value then the loop checks if the value is 
		// greater than the 0 then it iterates and keep on looping until the value is grater than 6
		for (int i=0; i<value; i++) {
			range = random.nextInt(upperBound);
			// prints out the dice 
			// i+1 = its because when you print i=0 the dice rolled start comes 0 so i+1 prevents the 0 
			//range+1= because the range is from 1 to 6	
			System.out.print("Die " + (i+1) + " rolled " + (range+1));

			// when the statement above is printed "|" comes after until the user input
			if (i+1<value) {
				System.out.print("|");

			}
		}
		System.out.println("");
		System.out.println("All dice rolled!");
		System.out.println("Thank you for playing, goodbye!");
		//boolean type needs a return statement  
		return true;
	}

}
