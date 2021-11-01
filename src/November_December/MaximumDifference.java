package November_December;

import java.util.Scanner;

/*
 * @author ethan huber
 *
 */
public class MaximumDifference {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];

        int[] twoLargest = new int[2];
        int[] twoSmallest = new int[2];

        // assign user inputted values to numbers
        System.out.println("Enter the 5 product numbers");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        int temp = 0;

        // find largest number
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            // if temp is bigger than the current large number
            if (temp > twoLargest[0]) {
                twoLargest[0] = temp;
            }
        }

        // find the second largesst number
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            if (temp > twoLargest[1] && temp != twoLargest[0]) {
                twoLargest[1] = temp;
            }
        }
                
        // find the smallest number
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            // if temp is bigger than the current large number
            if (temp < twoLargest[0]) {
                twoSmallest[0] = temp;
            }
        }

        // find the biggest number
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            if (temp < twoLargest[1] && temp != twoSmallest[0]) {
                twoSmallest[1] = temp;
            }
        }
        
        int maxDif = twoLargest[0] * twoLargest[1] - twoSmallest[0] * twoSmallest[1];
        
        System.out.println("The max difference is " + maxDif);

    }
}
