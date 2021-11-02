package November_December;

import java.util.Scanner;

/**
 * @author ethan
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = {"puppy", "watermelon", "balloon", "bean"};

        int wrongAttempts = 1;

        String[] guessed = new String[26];
        int indexOfGuessed = 0;

        // Game introduction
        System.out.println("Welcome to Hangman!");
        System.out.println("The game of hangman has you guess letters in a word");
        System.out.println("You get a limited amount of tries");
        System.out.println("Guess too many wront letters and you lose");
        System.out.println("Press enter to continue...");

        String waitFor;
        waitFor = input.nextLine();

        boolean run = true;

        // assign empty valuess to guessed so it prints nicely
        for (int i = 0; i < guessed.length; i++) {
            guessed[i] = "";

        }

        // game run
        do {
            // check if lost
            if (wrongAttempts == 5) {
                run = false;
            }

            // gui
            System.out.println("/-------\\");
            for (int i = 0; i < 5 - wrongAttempts; i++) {
                System.out.println("|       |");
            }

            System.out.println("|       O ");
            System.out.println("|      -|-");
            System.out.println("|      / \\");

            for (int i = 0; i < wrongAttempts; i++) {
                System.out.println("|");
            }

            System.out.println("+-----------+");

            // prints already made guesses
            for (int i = 0; i < guessed.length; i++) {
                if (guessed[i] != "") {
                    System.out.print(guessed[i] + " ");
                }
            }

            System.out.println("");

            // gets user guess
            System.out.println("Guess a letter");

            String letter = input.nextLine();

            boolean alreadyGuessed = false;

            for (int i = 0; i < guessed.length; i++) {
                if (letter.equals(guessed[i])) {
                    System.out.println("Letter already guessed try another");
                    alreadyGuessed = true;
                }
            }

            // adds user guess to the list of guessed letters
            if (alreadyGuessed == false) {
                guessed[indexOfGuessed] = letter;
                indexOfGuessed++;
            }

            // print _ if no character in the guessed array matches
            // if a character in the guessed array matches print correct letter
            // if whole word is the same make win = true
            if (run == false) {
                System.out.println("You lost!");
            }
        } while (run);
    }
}
