package November_December;

import java.util.Scanner;

/*
 * @author ethan huber
 */
public class SumFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers to use");

        int amount = input.nextInt();
        int[] numbers = new int[amount];

        System.out.println("Enter " + amount + " numbers");
        for (int i = 0; i < amount; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.println("What is your target sum to find pairs of");
        int sum = input.nextInt();

        int temp;

        // find numbers that make 15
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                if (temp + numbers[j] == sum) {
                    System.out.println(temp + " + " + numbers[j]);
                }
            }
        }
    }
}
