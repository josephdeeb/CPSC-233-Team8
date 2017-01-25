/*
	First implimentation of Team 8's project.
	This main method displays a small menu
	and promts for the users input on what
	they would like to do within the menu.
*/

import java.util.Scanner;

public class StartMenu {
	public static void main(String [] args) {
		
		//  Declare a boolean to control the while loop
		boolean isValid = false;
		
		// While loop controlled by a boolean to re-promt for user input
		while (isValid == false) {
			
			//  Displays the menu to the user and takes in user input on what they would like to do
			Scanner keyboard = new Scanner(System.in);
			System.out.println("\n====Menu====\n 1) Start game\n 2) Settings\n 3) Instructions\n 4) Exit");
			System.out.print("Enter choice here: ");
			String menuInput = keyboard.nextLine();

			// Checks the length of the users input and if the input is a digit
			int inputLen = menuInput.length();
			boolean isDigit = Character.isDigit(menuInput.charAt(0));
			
			// If the input satisfies the conditions of being a single digit 
			if ((inputLen == 1) && (isDigit == true)) {
				int finalInput = Integer.parseInt(menuInput);
				
				// checks for valid range of options
				if ((finalInput > 4) || (finalInput == 0)) {
					System.out.println("Incorrect Input! Enter a number between 1-4.");
				} else {
					switch (finalInput) {
						
					// Four cases associated with the four menu options
						case 1:
							System.out.println("Game Started");
							isValid = true;
							break;
						case 2:
							System.out.println("Settings");
							isValid = true;
							break;
						case 3:
							System.out.println("Instructions");
							isValid = true;
							break;
						case 4:
							System.out.println("Exit");
							isValid = true;
							break;
					}
				}
			}
			
			// If the input is not a single digit it lets the user know that they did not enter a correct value
			// Re-promts for input after by the implementation of the while loop
			else {
				System.out.println("Incorrect Input! Try again!");
			}
		}
	}	
}
			
			
									
							
