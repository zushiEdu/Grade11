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
public class MultiplesDistribution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);

        System.out.println("To what number should multiples be calculated to");
        int max = input.nextInt();

        int[] multiples = new int[11];

        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i % j == 0) {
                    multiples[j]++;
                }
            }
        }

        for (int i = 1; i < multiples.length; i++) {
            if (multiples[i] < 100){
                System.out.print(" ");
            }
            System.out.print(multiples[i] + " ");
            if (i < 10){
                System.out.print(" ");
            }
            System.out.print(i + " ");
            for (int j = 0; j < multiples[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
