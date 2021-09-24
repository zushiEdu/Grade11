package MathPractices;


import java.util.Scanner;

/**
 *
 * @author hubee8329
 */
public class MathPractice5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter an integer:");
        int number = input.nextInt();

        if ((number % 2) == 0) {
            System.out.println(number + " is an even number");
        } else if ((number % 2) > 0) {
            System.out.println(number + " is an odd number");
        }

        input.close();

    }

}
