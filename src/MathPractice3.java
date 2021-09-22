
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hubee8329
 */
public class MathPractice3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
    }

}
