import java.io.*;
import java.util.*;

public class Reading {

    public static void main(String[] args) throws IOException {

	Scanner keyboard = new Scanner(System.in);

	System.out.println();
	scanner();
	System.out.println();
	System.out.println("Press enter for BufferedReader");
	keyboard.nextLine();
	reader();
	keyboard.close();
    }

    public static void scanner() {

	File file = new File("conversation.txt");
	try {
	    Scanner reader = new Scanner(file);
	    while (reader.hasNextLine()) {
		System.out.println(reader.nextLine());

	    }
	   
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public static void reader() throws IOException {
	BufferedReader reader = new BufferedReader(new FileReader("conversation.txt"));
	Scanner scan = new Scanner(System.in);

	while (reader.ready()) {
	    System.out.println(reader.readLine());
	    System.out.print(reader.readLine());
	    scan.nextLine();
	}

    }

}