import com.sun.tools.javac.util.Convert;

// exception used for Q5
class CalculateException extends RuntimeException {
	public CalculateException(String err) {
		super(err);
	}
}

public class Calculator {

	/*
	 * Methods for Part 3
	 */
	public static int calculate(String[] cmds) {

		// made cmdscopy so doesnt interfere with the memory and stored in the array
		// length
		String[] cmdscopy = new String[cmds.length];
		// created for loop to store the index of the cmds to a copy array
		for (int i = 0; i < cmds.length; i++) {
			cmdscopy[i] = cmds[i];
		}
		// created stack size 100
		Stack pstack = new Stack(100);
		// variables
		String fst;
		String snd;
		// Calling out the reverse class and putting in the cmdscopy file
		Reverse.reverse(cmdscopy);
		// creating another for loop
		for (int i = 0; i < cmdscopy.length; i++) {
			// if isNumber is ture then the stack pushes the copy into the index
			if (isNumber(cmdscopy[i])) {
				pstack.push(cmdscopy[i]);
			}
			// else the fst and snd (number) pops into the stack
			// once we get the final result then you push into then stack using applyOp
			// operators
			else {
				fst = pstack.pop().toString();
				snd = pstack.pop().toString();
				pstack.push(applyOp(fst, cmdscopy[i], snd));
			}

		}
		// returns the final result using the convert method
		return convert(pstack.pop().toString());

	}

	public static int convert(String s) throws NumberFormatException {
		// this method returns the conversion from String to Integer
		return Integer.parseInt(s);
	}

	public static boolean isNumber(String s) {
		// try and catch blocked used to check if the array contains a Integer
		try {
			// it converts the String to integer
			convert(s);
			return true;

		}
		// else returns false
		catch (NumberFormatException e) {
			return false;
		}
	}

	// apply the operator after converting the numbers
	public static int applyOp(String fst, String op, String snd) {

		// return if op.equals("+")? Integer.parseInt(fst) + Integer.parseInt(snd): if
		// op.equals("-") ? Integer.parseInt(fst) - Integer.parseInt(snd)

		// this method checks if the operator is equal too + then returns the addition
		// of number
		if (op == "+") {
			return convert(fst) + convert(snd);
			// dummy value
		}
		// else if the operator is equal too - then returns the subtraction of number
		else if (op == "-") {
			return convert(fst) - convert(snd);
		}
		// else if the operator is equal too / then returns the division of number
		else if (op == "/") {
			return convert(fst) / convert(snd);
		}
		// else the operator is equal too * then returns the multiplication of number
		else {
			return convert(fst) * convert(snd);
		}

	}

	// main operation to calculate using Polish notation directly
	public static int calculatePolish(String[] cmds) {
		return -1; // dummy value
	}
}
