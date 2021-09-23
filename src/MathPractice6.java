
import java.util.Scanner;

/**
 *
 * @author hubee8329
 */
public class MathPractice6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter an integer:");
        int num1 = input.nextInt();
        System.out.println("Please anter another integer:");
        int num2 = input.nextInt();

        if (num1 >= num2) {
            System.out.println("Your numbers in ascending order are " + num2 + ", " + num1);
        }

        input.close();

    }
}
