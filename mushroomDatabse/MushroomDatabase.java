import java.util.Scanner;

/**
 * 
 * Software Development 1, Coursework 2.
 * 
 * Make sure you read the specification document on
 * Canvas in full before starting this assessment.
 * 
 */
public class MushroomDatabase {

	public static void main(String[] args) {

		System.out.println("Welcome to Mushroom Database!");
		System.out.println("How many records to you wish to input?");
		Scanner scan= new Scanner(System.in);

		int records = scan.nextInt();

		String choice;
		String color;
		String edible;
		String edibility = "";
		String [] nameArray;
		String [] colorArray;
		boolean [] edibilityArray;
		boolean quit = false;
		nameArray = new String[records]; //store records in nameArray
		colorArray = new String [records];
		edibilityArray= new boolean[records];

		for (int i= 1; i<=records; i++) {
			System.out.println("Enter details for record " + i);
			System.out.println("Name: ");
			nameArray[i - 1] = scan.next();
			System.out.println("Colour: ");
			colorArray[i - 1] = scan.next();
			System.out.println("Edibility (y/n): ");
			edibility = scan.next();
			if (edibility.equals("y")) {
				edibilityArray[i - 1]  = true;
			}
			else if (edibility.equals("n")) {
				edibilityArray[i - 1]= false;
			}
		}
		do {
			System.out.println("List (a)ll, search by (c)olour or (e)dibility, or (q)uit?");
			choice=scan.next();
			if (choice.equals("a")) {
				System.out.println("These are all the mushrooms in the database:");
				for(int i=0; i<nameArray.length; i++) {
					System.out.println(nameArray[i]);
				}
			}
			else if (choice.equals("c")) {
				System.out.println("Which colour?");
				color= scan.next();
				System.out.println("These are all the " + color + " mushrooms in the database:");
				for (int i=0; i<colorArray.length; i++) {
					if ((colorArray[i]).equals(color))
						System.out.println(nameArray[i]);
				}
			}
			else if (choice.equals("e")) {
				System.out.println("Search for (e)dible or (n)on-edible?");
				edible= scan.next();
				if (edible.equals("e")) {
					System.out.println("These are all the edible mushrooms in the database :-");
					for (int i=0; i<edibilityArray.length; i++ ) 
						if ((edibilityArray[i])== true) {
							System.out.println(nameArray[i]);
						}
				}
				else if (edible.equals("n"))
					for (int i=0; i<edibilityArray.length; i++ )
						if (((edibilityArray[i])== false)) {

							System.out.println(nameArray[i]);
						}			
			}	
			else if (choice.equals("q")) {

				quit = true;
				System.out.println("Thank you for using Mushroom Database!");
			}
		} while (quit==false);
		
	}

}
