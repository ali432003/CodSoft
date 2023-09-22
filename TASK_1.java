package CodSoft;

import java.util.Random;
import java.util.Scanner;

public class TASK_1 {

    public static void main(String[] args) {
        Random random = new Random();
        int randNum = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\tWelcome To Guessing The Correct Number Game\n");
        int trials = 10;
        int score = 100;
        boolean play = true;

        while (trials > 0 && play) {
            System.out.println("Enter A Number Between 1 & 100:");
            int user = scanner.nextInt();

            if (user > randNum) {
                System.out.println("Guess A Lower Number");
            } else if (user < randNum) {
                System.out.println("Guess A Higher Number");
            } else {
                System.out.println("\n\t\t Congratulations! You guessed the number " + randNum);
                System.out.println("\n\t Do you want to play again (yes/no)");
                String x = scanner.next();
                if (x.equals("yes")) {
                    randNum = random.nextInt(100) + 1; // Generate a new random number
                    trials = 10;
                    score = 100;
                } else {
                    play = false;
                    System.out.println("Thank you for playing");
                }
            }

            trials--;
            score -= 10;

            if (trials == 0 && user != randNum) {
                System.out.println("\n\t\t Better Luck Next time! You ran out of trials. The number was: " + randNum);
                System.out.println("\n\t Do you want to play again (yes/no)");
                String x1 = scanner.next();
                if (x1.equals("yes")) {
                    randNum = random.nextInt(100) + 1; // Generate a new random number
                    trials = 10;
                    score = 100;
                } else {
                    play = false;
                    System.out.println("Thank you for playing..");
                }
            }
        }
        scanner.close(); // Close the scanner to prevent resource leak
    }
}
