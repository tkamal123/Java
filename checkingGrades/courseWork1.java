import java.util.Scanner;

public class courseWork1 {
public static void main(String[] args) {


	
		System.out.println("Which degree programme are you studying on? (Enter CSci or CSys)");
		Scanner scan = new Scanner(System.in);
		String programme = scan.next();
		System.out.println("Please enter marks for the courses F27SA, F27ID, F27PX and F17LP");
		double F27SA = scan.nextInt();
		double F27ID = scan.nextInt();
		double F27PX = scan.nextInt();
		double F17LP = scan.nextInt();
		double average = ((F27SA + F27ID + F27PX + F17LP) / 4);
		System.out.println("Your average mark across these four courses is " + average + "%");
	

		
	if (programme.matches("CSci")) {
		if  (((F27SA>=40) && (F27ID>=40) && (F27PX>=30) && ((F17LP>=40)))) {
			
			System.out.println("For this semester, you have met the requirements to proceed to your next year of study for the degree programme BSc Computer Science");
	
		 }
		 

		else {
			 System.out.println("For this semester, you have not yet met the requirements to proceed to your next year of study for the degree programme BSc Computer Science.");
		 }
	}
	
	else{
		
		 if (((F27SA>=40) && ((F27ID>=40) && ((F27PX>=30) && ((F17LP>=30) ))))) {
			 System.out.println("For this semester, you have met the requirements to proceed to your next year of study for the degree programme BSc Computer System");
		 }
		 else {
			 System.out.println("For this semester, you have not yet met the requirements to proceed to your next year of study for the degree programme BSc Computer System.");
		 }
	}
			 
}
}
