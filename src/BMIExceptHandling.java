import java.util.Scanner;

public class BMIExceptHandling {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int weightVal = 0; // User defined weight (lbs)
		int heightVal = 0; // User defined height (in)
		float bmiCalc = 0.0f; // Resulting BMI
		char quitCmd = 'a'; // Indicates quit/continue

		while (quitCmd != 'q') {

			try {


				// Get user data
				System.out.print("Enter weight (in pounds): ");
				
				// Error checking, non-numeric data
				if (!scnr.hasNextInt()) {
					scnr.nextLine();
					throw new Exception("Please enter in numeric data.");
					
				}
				weightVal = scnr.nextInt();

				// Error checking, non-negative weight
				if (weightVal < 0) {
					throw new Exception("Invalid weight.");
					
				}

				System.out.print("Enter height (in inches): ");
				heightVal = scnr.nextInt();

				// Error checking, non-negative height
				if (heightVal < 0) {
					throw new Exception("Invalid height.");
				}

				// Calculate BMI and print user health info if no input error
				// Source: http://www.cdc.gov/
				bmiCalc = ((float) weightVal / (float) (heightVal * heightVal)) * 703.0f;

				System.out.println("BMI: " + bmiCalc);
				System.out.println("(CDC: 18.6-24.9 normal)");
			} catch (Exception excpt) {
				// Prints the error message passed by throw statement
				System.out.println(excpt.getMessage());
				System.out.println("Cannot compute health info");
			}

			// Prompt user to continue/quit
			System.out.print("\nEnter any key ('q' to quit): ");
			quitCmd = scnr.next().charAt(0);
		}

		return;
	}
}