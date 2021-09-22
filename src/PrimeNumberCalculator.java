
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
public class PrimeNumberCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // A prime number is something that can only be divided by itself and 1
        // 1. Get number
        // 2. Loop through multiples from 2 to itself to see if it is divisible by anything other than itself and 1
        // 3. If it found a multiple and it isn't itself then its not a prime
        // 4. If it made it through the whole loop it is a prime
        // Note, number, index amount, prime value

        System.out.println("Enter an integer to determine if it is a prime number or not");

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int index = 2;
        int stop = 0;

        while (stop == 0){
            if (number % index == 0 && number % 2 != 0) {
                System.out.println("This number is prime");
                stop = 1;
            } else if (number == index){
                System.out.println("This number isn't prime");
                stop = 1;
            } else if (number == 1){
                System.out.println("This number is prime");
                stop = 1;
            } else {
                index = index + 1;
                System.out.println(index +","+ number);
            }
        }
    }
}
