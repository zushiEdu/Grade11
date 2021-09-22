/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hubee8329
 */
public class FizzBuzzLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int index = 0;

        while (index < 101) {
            if ((index % 15) == 0) {
                System.out.println(index + ", FizzBuzz");
            } else if ((index % 5) == 0) {
                System.out.println(index + ", Buzz");
            } else if ((index % 3) == 0) {
                System.out.println(index + ", Fizz");
            } else {
                System.out.println(index);
            }
            index = index + 1;
        }
    }

}
