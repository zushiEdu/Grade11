
import java.util.Scanner;

/**
 *
 * @author hubee8329
 */
public class WhileLoops {

    public static void main(String[] args) {
        //delay (start of segment)

        //try{
        //    Thread.sleep(1000);
        //} catch(Exception e){} 
        
        //delay (end of segment)
        Scanner input = new Scanner(System.in);

        // count from 1 to 10
        int count = 1;
        int sum = 0;

        while (count <= 10) {
            //print out count
            System.out.println(count);
            // add number to the sum
            sum = sum + count;
            //add one to count
            count = count + 1;
        }

        System.out.println("The total fromm 1-10 is: " + sum);

        // make sure the number input is between 1 and 10
        int number;

        do {
            System.out.println("Please enter a number between 1 and 10");
            number = input.nextInt();
        } while (number < 1 || number > 10);
    }
}
