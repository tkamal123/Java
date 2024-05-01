package oop1.translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// Declaring the required variables and arraylists *
public class Responder {
	//acts like an array its a list that contains vaule that has a key
	private HashMap<String, String> englishToGerman;
	private HashMap<String, String> englishToFrench;
	private HashMap<String, String> spanishToEnglish;
	private ArrayList<String> errorResponses;
	private int lastIndex = 0;
	private Random rnd;

	public Responder() {
		rnd = new Random();
		spanishToEnglish = new HashMap<>();
		fillSpanishToEnglish();
		englishToGerman = new HashMap<>();
		fillEnglishToGerman();
		englishToFrench = new HashMap<>();
		fillEnglishToFrench();
		errorResponses = new ArrayList<>();
		fillErrorResponses();

	}

	// Method to add all the words with their corresponding translation into the *
	
	private void fillEnglishToGerman() {
		englishToGerman.put("hello", "hallo");
		englishToGerman.put("saussage", "wurst");
		englishToGerman.put("beer", "bier");
		englishToGerman.put("table", "tisch");
		englishToGerman.put("chair", "stuhl");
		englishToGerman.put("i", "ich");
		englishToGerman.put("you", "du/sie");
		englishToGerman.put("the", "der/die/das");
		englishToGerman.put("work", "arbeit");
		englishToGerman.put("mother", "Mutter"); // Unique words for german
		englishToGerman.put("leader", "Führer"); // *
	}

	// Method to add all the words with their corresponding translation into the *
	// Arraylist *
	private void fillEnglishToFrench() {
		englishToFrench.put("hello", "salut");
		englishToFrench.put("saussage", "saucisson");
		englishToFrench.put("beer", "Bière");
		englishToFrench.put("table", "tableau");
		englishToFrench.put("chair", "chaise");
		englishToFrench.put("i", "je");
		englishToFrench.put("you", "vous");
		englishToFrench.put("the", "la (feminine)\n" + "          le (masculine)");
		englishToFrench.put("work", "travail");
		englishToFrench.put("boy", "garçon"); // Unique words for french
		englishToFrench.put("girl", "fille"); // *
	}

	// Method to add all the words with their corresponding translation into the *
	// Arraylist *
	private void fillSpanishToEnglish() {
		spanishToEnglish.put("hola", "hello");
		spanishToEnglish.put("embutido", "saussage");
		spanishToEnglish.put("cerveza", "beer");
		spanishToEnglish.put("mesa", "table");
		spanishToEnglish.put("silla", "chair");
		spanishToEnglish.put("yo", "i");
		spanishToEnglish.put("usted", "you");
		spanishToEnglish.put("la", "the");
		spanishToEnglish.put("el", "the");
		spanishToEnglish.put("trabaja", "work");
	}

	// Translating the inputted words using a series of if else conditions *
	public String translate(String input) {

		String englishResult = spanishToEnglish.get(input);
		String germanResult = englishToGerman.get(input);
		String frenchResult = englishToFrench.get(input);

		if (spanishToEnglish.containsKey(input)) {
			input = englishResult;
			System.out.println("English : " + englishResult);
			germanResult = englishToGerman.get(input);
			frenchResult = englishToFrench.get(input);
			System.out.println("German  : " + germanResult);
			System.out.println("French  : " + frenchResult);
			return "=====================";
		} else if (englishToGerman.containsKey(input) && englishToFrench.containsKey(input)) {
			System.out.println("German  : " + germanResult);
			System.out.println("French  : " + frenchResult);
			return "=====================";
		} else if (englishToGerman.containsKey(input)) {
			System.out.println("German  : " + germanResult);
			return "French  : Sorry, the translation for this word doesn't exist yet :|";
		} else if (englishToFrench.containsKey(input)) {
			System.out.println("French  : " + frenchResult);
			return "German  : Sorry, the translation for this word doesn't exist yet :|";
		} else {
			return getErrorResponse();
		}
	}

// Method to generate a random number and prevent it from repeating *
	public int avoidRepetition() {
		int index;

		do {
			index = rnd.nextInt(errorResponses.size());
		} while (lastIndex == index);
		lastIndex = index;
		return index;
	}

// Method to store all the error statements in the ArrayList *
	public void fillErrorResponses() {
		// Adding responses to be used if no translation was found.
		errorResponses.add("I am sorry but I do not know how to translate this.");
		errorResponses.add("I don't know this word, sorry.");
		errorResponses.add("Are you sure that this is a word?");
		errorResponses.add("This cannot be translated.");
	}

// Method to print a error statement if the user inputs a invalid word *
	public String getErrorResponse() {
		// printing the error *

		int idx = avoidRepetition();
		return errorResponses.get(idx);
	}
}