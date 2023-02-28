// Sabir Hayatullah
// This code asks the user to enter 7 different random numbers and he has to find the random number in 7 tries if not he fails.
// Example 1


// imported the scanner 
import java.util.Scanner;
public class RandomNumberGuesser {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        int randNum, nextGuess;
        int lowGuess = 0;
        int highGuess = 100;
        boolean isCorrect = false;
        String input = "y";
        int numGuesses = 0; // track number of guesses
        
        while (input.equalsIgnoreCase("y")) {
            RNG.resetCount();
            randNum = RNG.rand();
            System.out.println("This application generates a random integer between 0 and 100\n"
                    + "  and asks the user to guess repeatedly until they guess correctly.\n"
                    + "");
            System.out.println("Enter your first guess");
            
            
            
            // add condition to stop after 7 incorrect guesses
            while (!isCorrect && numGuesses < 7) {
            	
                nextGuess = scanner.nextInt();
                
                if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
                	
                    numGuesses++; // increment number of guesses
                    
                    if (nextGuess == randNum) {
                        isCorrect = true;
                        System.out.println("Congratulations, you guessed correctly");
                    } else if (nextGuess < randNum) {
                        lowGuess = nextGuess;
                        System.out.println("Your guess is too low");
                    } else {
                        highGuess = nextGuess;
                        System.out.println("Your guess is too high");
                    }
                    System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
	                
                }
            }
            
            // print appropriate message based on whether user guessed correctly or not
            if (isCorrect) {
                System.out.println("You took " + RNG.getCount() + " guesses");
            } else {
                System.out.println("Sorry, you did not guess the number within 7 tries");
            }
            
            System.out.println("Do you want to play again? (y/n)");
            input = scanner.next();
            
            // reset values for next game
            lowGuess = 0;
            highGuess = 100;
            isCorrect = false;
            numGuesses = 0;
        }
        
        System.out.println("Thanks for playing!");
        System.out.println("Programmer: Sabir Hayatullah");
    }
}