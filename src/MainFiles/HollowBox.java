package MainFiles;

import java.util.Scanner;

/**
 *
 * @author ethan huber
 */
public class HollowBox {

    public static void main(String[] args) {
        // creates a scanner
        Scanner input = new Scanner(System.in);

        // ask user how big the box should be
        System.out.println("How big should the hollow box be?");

        // set size to user input
        int size = input.nextInt();

        // print rows
        for (int i = 1; i <= size; i++) {
            // if first or last row print 5 across
            if (i == 1 || i == size) {
                // if last line print a new line before printing
                if (i == size) {
                    System.out.println("");
                }
                // print stars size amount
                for (int j = 0; j < size; j++) {
                    System.out.print("* ");
                }
            } else {
                //print a new line for the hollow part
                System.out.println("");
                // print star then spaces for size - 2 then another asterisk
                System.out.print("* ");
                // print the spaces in the box
                for (int j = 0; j < size - 2; j++) {
                    System.out.print("  ");
                }
                //print the ending star
                System.out.print("* ");
            }
        }
    }
}
