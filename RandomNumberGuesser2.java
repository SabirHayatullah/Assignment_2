// Sabir Hayatullah
// This code asks the user find the random number doesn't matter in how mnay tires.
// Example 2
import java.util.Scanner;
public class RandomNumberGuesser2 {

	public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
	        RNG.resetCount(); // reset the guess count
	        int randNum; // the random number to be guessed
	        int lowGuess = 0, highGuess = 100; // initialize lowGuess and highGuess
	        String repeat; // used to determine if the user wants to repeat the game

	        do {
	            randNum = RNG.rand();
	            System.out.println("This application generates a random integer between 0 and 100\n"
	                    + "  and asks the user to guess repeatedly until they guess correctly.\n"
	                    + "");
	            System.out.println("Enter your first guess");
	            int guess = scan.nextInt();
	            while (guess != randNum) {
	                if (!RNG.inputValidation(guess, lowGuess, highGuess)) {
	                    // if the guess is invalid, skip to the next iteration
	                    guess = scan.nextInt();
	                    continue;
	                }
	                if (guess < randNum) {
	                    lowGuess = guess;
	                    System.out.println("Your guess is too low");
	                } else if (guess > randNum) {
	                    highGuess = guess;
	                    System.out.println("Your guess is too high");
	                }
	                System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
	                guess = scan.nextInt();
	            }
	            // guess is equal to randNum, game is over
	            System.out.println("Congratulations, you guessed correctly!");
	            System.out.println("You made " + RNG.getCount() + " guesses");
	            System.out.println("Try again? (y or n)");
	            repeat = scan.next();
	            lowGuess = 0;
	            highGuess = 100;
	        } while (repeat.equals("y"));
	        
	        System.out.println("Thanks for playing!");
	        System.out.println("Programmer: Sabir Hayatullah");
	        
	        scan.close();
	    }
	
		

	}


