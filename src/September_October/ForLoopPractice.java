package September_October;

/**
 *
 * @author ethan huber
 */
public class ForLoopPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // while loop that counts from 0 to 10
        int count = 0;
        while (count <= 10) {
            System.out.println(count);
            count++;
        }

        // for loop that counts from 0 to 10
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        // add the numbers from 1 to 100
        int sum = 0;
        // for loop that goes from one to 100
        for (int i = 1; i <= 100; i++) {
            // adding each number to the sum
            sum = sum + i;
        }
        // prints the answer
        System.out.println("Sum: " + sum);

        // for and tab makes a for loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i * i);
        }
    }
}
