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
public class FactorialRecursion {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static int sum = 1;

    public static void main(String[] args) {
        // get factorial of user response to message
        factorial(userInput("What number to get factorial of"));
    }

    public static int userInput(String message) {
        System.out.println(message);
        return input.nextInt();
    }

    public static void factorial(int num) {
        // while number is greater than one continue calculating factorial
        if (num > 1) {
            num--;
            sum = sum * num;
            factorial(num);
        } else {
            // print status and sum
            System.out.println("Done");
            System.out.println(sum);
        }
    }
}
