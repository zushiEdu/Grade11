
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
public class MathPractice7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the amount the customer spent");
        double spentAmount = input.nextDouble();

        if (spentAmount >= 0.01 && spentAmount < 40.00) {
            //10% off
            System.out.println("They will recieve 10% off.");
            System.out.println("They will save $" + (spentAmount * 0.10) + " off.");
            System.out.println("The new total is $" + (spentAmount * 0.90) + ".");
        } else if (spentAmount > 40.01 && spentAmount < 80.00) {
            //20% off
            System.out.println("They will recieve 20% off.");
            System.out.println("They will save $" + (spentAmount * 0.20) + " off.");
            System.out.println("The new total is $" + (spentAmount * 0.80) + ".");
        } else if (spentAmount > 80.01 && spentAmount < 120) {
            //30% off
            System.out.println("They will recieve 30% off.");
            System.out.println("They will save $" + (spentAmount * 0.30) + " off.");
            System.out.println("The new total is $" + (spentAmount * 0.70) + ".");
        } else if (spentAmount > 120.01) {
            //40% off
            System.out.println("They will recieve 40% off.");
            System.out.println("They will save $" + (spentAmount * 0.40) + " off.");
            System.out.println("The new total is $" + (spentAmount * 0.60) + ".");
        }
    }

}
