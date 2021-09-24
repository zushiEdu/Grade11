package MathPractices;


import java.util.Scanner;

/**
 *
 * @author hubee8329
 */
public class MathPractice3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter in the x coordinate of the first point");
        double x1 = input.nextInt();
        System.out.println("Please enter in the y coordinate of the first point");
        double y1 = input.nextInt();
        System.out.println("Please enter in the x coordinate of the second point");
        double x2 = input.nextInt();
        System.out.println("Please enter in the y coordinate of the second point");
        double y2 = input.nextInt();

        if (x1 == x2) {
            System.out.println("Undefined Slope");
        } else {
            System.out.println("The slope of your line would be " + (y2 - y1) / (x2 - x1));
        }
        input.close();

    }

}
