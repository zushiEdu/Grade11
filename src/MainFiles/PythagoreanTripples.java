package MainFiles;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author hubee8329
 */
public class PythagoreanTripples {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Input 3 integers to determine if they form a Pythagorean Tripple");
        double number1 = input.nextInt();
        double number2 = input.nextInt();
        double number3 = input.nextInt();

        System.out.println(number1 + "," + number2 + "," + number3);

        if (Math.pow(number1, 2) + Math.pow(number2, 2) == Math.pow(number3, 2)) {
            System.out.println(number1 + "² + " + number2 + "² = " + number3 + "²");
        } else if (Math.pow(number3, 2) - Math.pow(number1, 2) == Math.pow(number2, 2)) {
            System.out.println(number2 + "² + " + number3 + "² = " + number1 + "²");
        } else if (Math.pow(number1, 2) - Math.pow(number3, 2) == Math.pow(number2, 2)) {
            System.out.println(number2 + "² + " + number3 + "² = " + number1 + "²");
        }
        input.close();
    }
}
