/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package November_December;

import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class PrimeFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // ask user for input
        System.out.println("Enter a number to see if it is prime");
        // get user input
        int num = input.nextInt();
        boolean prime = isPrime(num);
        // output the answer
        System.out.println("Is " + num + " prime?: " + prime);
    }
    
    public static boolean isPrime(int n){
        boolean prime = true;
        // count from 0 to n
        for (int i = 2; i < n - 1; i++) {
            // if this number can be divisible by anything except 1 and itself
            if (n % i == 0){
                prime = false;
            }
        }
        return prime;
    }
}
