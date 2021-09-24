package MathPractices;


import java.util.Scanner;

/**
 *
 * @author hubee8329
 */
public class MathPractice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter in two integers, on seperate lines, to divide.");

        int number1 = input.nextInt();
        int number2 = input.nextInt();

        System.out.println(number1 + "/" + number2 + " is " + (number1 / number2) + " with a remainder of "
                + (number1 % number2) + ".");

        input.close();

    }
}
