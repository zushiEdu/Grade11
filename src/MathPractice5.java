
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
public class MathPractice5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter an integer:");
        int number = input.nextInt();
        
        if ((number % 2) == 0){
            System.out.println(number + " is an even number");
        } else if ((number % 2 ) > 0){
            System.out.println(number + " is an odd number");
        }
    }
    
}
