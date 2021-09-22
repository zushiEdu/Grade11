
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
public class MathPractice4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        System.out.println("How many chromebook chargers?");
        int amountChargers = input.nextInt();
        System.out.println("How many motherboards?");
        int amountMotherboards = input.nextInt();
        System.out.println("How many mice?");
        int amountMice = input.nextInt();

        System.out.println("Subtotal = $" + ((amountChargers * 34.99) + (amountMotherboards * 127.50) + (amountMice * 18.00)));
        System.out.println("Taxes = $" + ((amountChargers * 34.99) + (amountMotherboards * 127.50) + (amountMice * 18.00)) * 0.13);
        System.out.println("Total = $" + ((amountChargers * 34.99) + (amountMotherboards * 127.50) + (amountMice * 18.00)) * 1.13);
    }
}
