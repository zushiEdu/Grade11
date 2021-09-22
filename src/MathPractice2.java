
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
public class MathPractice2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter in two integers, on seperate lines, to divide.");
        
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        
        System.out.println(number1 + "/" + number2 + " is " + (number1/number2) + " with a remainder of " + (number1 % number2) + ".");
    }
}
