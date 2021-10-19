package MainFiles;

import java.util.Scanner;

/**
 *
 * @author ethan huber
 */
public class StarTriangle {

    public static void main(String[] args) {
        // create scanner
        Scanner input = new Scanner(System.in);
        
        // ask user how big the star should be
        System.out.println("How big should the star be?");
        
        // set user input to size int
        int size = input.nextInt();

        // make a rows of trinagle
        for (int i = 0; i <= size; i++) {
            // print spaces for the difference of size and row amount
            for (int j = 0; j < size - i; j++) {
                System.out.print(" ");
            }
            // print stars for the collums in current row amount
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            // print new line after the row has been made
            System.out.println("");
        }
    }
}
