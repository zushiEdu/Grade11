/*
 * Developed by Ethan Huber
 * Year of 2021 grade 11
 * Feel free to copy, redistribute and use
 */
package November_December;

import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class Translator {

    public static String toPigLatin(String word) {
        // does it start with a vowel
        word = word.toUpperCase();
        if (vowels(0, word)) {
            return word + "WAY";
        } else {
            // go through each letter
            for (int i = 1; i < word.length(); i++) {
                // if letter in word is a vowel
                if (vowels(i, word)) {
                    String back = word.substring(i);
                    String front = word.substring(0, i);
                    return back + front + "AY";
                }
            }
        }
        return word;
    }

    public static boolean vowels(int pos, String word) {
        // check for vowel at given position
        return word.charAt(pos) == 'A'
                || word.charAt(pos) == 'E'
                || word.charAt(pos) == 'I'
                || word.charAt(pos) == 'O'
                || word.charAt(pos) == 'O'
                || word.charAt(pos) == 'U';
    }

    public static String toEnglish(String word) {
        word = word.toUpperCase();
        if (word.substring(word.length() - 3).equals("WAY")) {
            //take way and remove it
            return word.substring(0, word.length() - 3);
        } else if ((word.substring(word.length() - 2)).equals("AY")) {
            word = word.substring(0, word.length() - 2);
            word = word.charAt(word.length() - 1) + word.substring(0);
            return word;
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Message to english or to piglatin from english");
        System.out.println("( piglatin / english )");
        String mode = input.nextLine();
        if (mode.equals("piglatin")) {
            System.out.println("Enter phrase to translate to piglatin");
            String line = input.nextLine();
            String[] words = line.split(" ");
            // translate every word in sentence
            for (int i = 0; i < words.length; i++) {
                // translate i word in words
                String translation = toPigLatin(words[i]);
                System.out.print(translation + " ");
            }
            System.out.println("");
        } else if (mode.equals("english")) {
            System.out.println(
                    "Enter phrase to translate from piglatin to english"
            );
            String line = input.nextLine();
            String[] words = line.split(" ");
            // translates words in sentence
            for (int i = 0; i < words.length; i++) {
                String translation = toEnglish(words[i]);
                System.out.print(translation + " ");
            }
            System.out.println("");
        }
    }
}
