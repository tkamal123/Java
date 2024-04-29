import java.util.*;
import java.io.*;
public class Hangman {

	File letters;
	Scanner fileCollectsData;
	String word;
	List<String> wordsList;
	int randomWord;
	String wordThatNeedsToBeFound;

	char[] wordThatNeedsToBeFoundArray;
	char[] userAnswer;
	ArrayList<String> gusses;


	public void printGameIntro() {
		try {
			//imports the file
			letters = new File("wordList.txt");
			//reads the file
			fileCollectsData = new Scanner(letters);
			//importing random
			Random random = new Random();
			//Searches the file
			word = fileCollectsData.nextLine();
			//Array list that stores the data and Splits in when the "," is the "delimiter"
			wordsList = new ArrayList<String>(Arrays.asList(word.split(",")));
			//creates a random index
			randomWord = random.nextInt(wordsList.size());
			//it will get a random word
			wordThatNeedsToBeFound = wordsList.get(randomWord);
			System.out.println("Welcome to Hangman");
			System.out.println("I'm thinking of a word");

		}
		//if the system could'nt find the file it will print error 
		catch (FileNotFoundException error) {
			System.out.println("An error occurred.");
			error.printStackTrace();

		}
	}

	public boolean processInput() {

		//importing scanner
		Scanner scan = new Scanner(System.in);
		//it takes the word and splits it into an array and stores it
		wordThatNeedsToBeFoundArray = wordThatNeedsToBeFound.toCharArray();
		userAnswer = new char[wordThatNeedsToBeFoundArray.length];
		//prints out incomplete word 
		gusses = new ArrayList<String>();
		//for loop that iterates through the array and sets each element to ?
		for (int i = 0; i<wordThatNeedsToBeFoundArray.length; i++) {
			userAnswer[i] = '?';
		}
		//variable correct boolean thats false
		boolean correct = false;
		// while loop that keeps running until the user enters every word thats correct
		while (correct==false) {
			System.out.println("");
			System.out.println("Enter a letter: ");
			String guess = scan.next();
			// u can't enter a number or a string 
			while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
				System.out.println("You can enter a single alphabet only, try again");
				guess = scan.next();
			}
			//if the user repeats the same letter again
			if (gusses.contains(guess)) {
				System.out.println("You already guessed that letter. Pick a different one!");
				guess = scan.next();
			}
			//variable found boolean thats false
			boolean found = false;
			// if the user enters a letter that is there more than once in the word or once it changes the underscore into the same letter
			for (int i =0; i< wordThatNeedsToBeFoundArray.length; i++) {
				if (guess.charAt(0) == wordThatNeedsToBeFoundArray[i]) {
					userAnswer[i] = wordThatNeedsToBeFoundArray[i];
					found = true;
				}
			}
			//if the word is correct it will print "yes...."
			if (found) {
				System.out.println("Yes, my word does have that letter!");
			}
			//if not found then "sorry..."
			if (!found) {
				System.out.println("Sorry, the word I am thinking of does not have this letter");
			}
			//variable done boolean is true
			boolean done = true;
			//for loop that prints the _ for the length of the word
			for (int i =0; i< userAnswer.length; i++) {
				if (userAnswer[i] == '?') {
					System.out.print("_");
					done  = false;
				}
				//this prints out the empty underscore
				else {
					System.out.print(""+  userAnswer[i]);
				}
			}
			//if the word is complete 
			if (done) {
				System.out.println("You've guessed my word! It was: "+wordThatNeedsToBeFound);
				//distinct prints out the count of unique letters 
				System.out.println("You needed to guess " +wordThatNeedsToBeFound.chars().distinct().count()+" letters.");
				correct = true;
			}
			//adds guesses
			gusses.add(guess);
		}
		return true;
	}
}
