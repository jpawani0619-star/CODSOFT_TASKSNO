package numbergame;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String playAgain = "yes";

        int roundsWon = 0;
        int totalRounds = 0;

        // Multiple rounds
        while (playAgain.equalsIgnoreCase("yes")) {

            totalRounds++;

            // Generate random number between 1 and 100
            int number = random.nextInt(100) + 1;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have 5 attempts to guess the number.");

            int guess = 0;
            int attempts = 0;
            int maxAttempts = 5;

            // Limited attempts
            while (guess != number && attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();

                attempts++;

                // Compare guess with generated number
                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("You guessed it in " + attempts + " attempts.");

                    roundsWon++;
                }
                else if (guess > number) {
                    System.out.println("Too high! Try a lower number.");
                }
                else {
                    System.out.println("Too low! Try a higher number.");
                }
            }

            // If all attempts are used
            if (guess != number) {
                System.out.println("Game Over! You used all 5 attempts.");
                System.out.println("The correct number was: " + number);
            }

            // Ask for another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.next();
        }

        // Display final score
        System.out.println("\n===== FINAL SCORE =====");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Rounds lost: " + (totalRounds - roundsWon));

        System.out.println("\nThank you for playing! 🎉");

        scanner.close();
    }
}