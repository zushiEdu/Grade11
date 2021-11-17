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
        if (vowel(0, word)) {
            return word + "WAY";
        } else {
            // go through each letter
            for (int i = 1; i < word.length(); i++) {
                // if letter in word is a vowel
                if (vowel(i, word)) {
                    String back = word.substring(i);
                    String front = word.substring(0, i);
                    return back + front + "AY";
                }
            }
        }
        return word;
    }

    public static boolean vowel(int pos, String word) {
        // check for vowel at given position
        return word.charAt(pos) == 'A'
                || word.charAt(pos) == 'E'
                || word.charAt(pos) == 'I'
                || word.charAt(pos) == 'O'
                || word.charAt(pos) == 'O'
                || word.charAt(pos) == 'U';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter word to translate to piglatin");
        String line = input.nextLine();
        String[] words = line.split(" ");
        // translate every word in sentence
        for (int i = 0; i < words.length; i++) {
            // translate i word in words
            String translation = toPigLatin(words[i]);
            System.out.print(translation + " ");
        }
        System.out.println("");
    }
}
