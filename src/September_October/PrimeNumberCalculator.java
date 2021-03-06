package September_October;

import java.util.Scanner;

/**
 *
 * @author hubee8329
 */
public class PrimeNumberCalculator {

    public static void main(String[] args) {
        //prime number checker
        
        System.out.println("Which number would you like to check?");

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int index = 2;
        int stop = 0;

        while (index < number && stop == 0) {
            if (number % index == 0) {
                if (number != index && number != 1) {
                    System.out.println("This number isn't a prime number");
                    stop = 1;
                }
            } else {
                index++;
            }
        }
        if (stop == 0) {
            System.out.println("This number is a prime number");
        }
        input.close();
    }
}
