package MainFiles;

import java.util.Scanner;

/**
 *
 * @author hubee8329
 */
public class CollatzConjecture {

    public static void main(String[] args) {
        System.out.println("Please enter a positive integer to see the hailstone sequence");
        Scanner input = new Scanner(System.in);

        int count = input.nextInt();

        while (count != 1) {
            if (count % 2 == 0) {
                System.out.println(count / 2);
                count = count / 2;
            } else {
                System.out.println((3 * count) + 1);
                count = 3 * count + 1;
            }
        }
    }
}
