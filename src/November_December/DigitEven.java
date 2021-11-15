/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package November_December;

import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class DigitEven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // ask user for input
        System.out.println("Enter a number to calculate if digits are all odd");
        // get user input
        int num = input.nextInt();
        // store the value
        boolean odd = allDigitsOdd(num);
        // output the answer
        System.out.println("Is " + num + " odd? " + odd);
    }

    public static boolean allDigitsOdd(int n) {
        boolean odd = true;
        // loop through number until whole number has been checked
        while (odd == true) {
            // get last digit and determine if divisible by 2
            if ((n % 10) % 2 == 0) {
                // n is even
                odd = false;
            } else {
                // take away last digit
                System.out.println(n);
                n = n / 10;
            }
        }
        // if whole number has no remainder
        if (n == 0) {
            odd = true;
        }
        return odd;
    }
}
