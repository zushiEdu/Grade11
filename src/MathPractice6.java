
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
public class MathPractice6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter an integer:");
        int num1 = input.nextInt();
        System.out.println("Please anter another integer:");
        int num2 = input.nextInt();
        
        if (num1 >= num2){
            System.out.println("Your numbers in ascending order are " + num2 + ", " + num1);
        }
    }
}
