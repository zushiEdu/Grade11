/*
 * Developed by Ethan Huber
 * Year of 2021 grade 11
 * Feel free to copy, redistribute and use
 */
package November_December;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class MineSweeper {

    /**
     * @param args the command line arguments
     */
    static Random rand = new Random();
    
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        boardPrint(boardGen(9));
        chooseMode(charInput("Place flag or mine (f/m)"), intInput("At what x coordinate (0-8)"), intInput("At what y coordinate (0-8)"));
    }
    
    public static char charInput(String message){
        System.out.println(message);
        return input.nextLine().charAt(0);
    }
    
    public static int intInput(String message){
        System.out.println(message);
        return input.nextInt();
    }

    public static boolean[][] boardGen(int size) {
        boolean[][] mines = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int r = rand.nextInt(4);
                mines[i][j] = r == 3;
            }
        }
        return mines;
    }

    public static void boardPrint(boolean[][] mines) {
        for (int i = 0; i < mines.length; i++) {
            for (int j = 0; j < mines[i].length; j++) {
                //System.out.print(checkSurrounding(j, i, mines) + " ");
                
                if (mines[j][i]){
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
    }
    
    public static void chooseMode(char m, int x, int y){
        if (m == 'f'){
            placeFlag(x, y);
        }
        if (m == 'm'){
            mineSweep(x, y);
        }
    }
    
    public static void placeFlag(int x, int y){
        System.out.println(x + " " + y);
    }
    
    public static void mineSweep(int x, int y){
        System.out.println(x + " " + y);
    }

    // FIX
    public static int checkSurrounding(int xC, int yC, boolean[][] mines) {
        int count = 0;
        for (int y = -1; y < 2; y++) {
            for (int x = -1; x < 2; x++) {
                if (xC + x != 0 && yC + y != 0) {
                    // every square around xC and xY
                    if (xC + x >= 0 && yC + y >= 0 && xC + x < mines.length && yC + y < mines[y].length) {
                        if (mines[yC + y][xC + x]) {
                            count++;
                        }
                    }
                }
            }
        }
        //System.out.print(count);
        return count;
    }
}
