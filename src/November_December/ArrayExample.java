package November_December;

import java.util.Scanner;

/**
 *
 * @author ethan huber
 */
public class ArrayExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Asks the user how many marks to input then saves it
        System.out.println("How many marks to average?");
        int numTests = input.nextInt();
        
        // Create the array
        int[] tests = new int[numTests];
        
        // Assigns inputs to tests array
        System.out.println("Please enter the test marks");
        for (int i = 0; i < numTests; i++) {
            tests[i] = input.nextInt();
        }
        
        // Adds the test marks to the sum
        int sum = 0;
        for (int i = 0; i < numTests; i++) {
            sum = sum + tests[i];
        }
        
        // Tells the user the sum divided by amount of tests (average)
        System.out.println("Your average is " + (sum / numTests));
    }
    
}
