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

    static boolean[][] mines = new boolean[9][9];
    static boolean[][] flags = new boolean[9][9];
    static boolean[][] mined = new boolean[9][9];

    static boolean run = true;

    public static void main(String[] args) {
        // TODO code application logic here

        boardGen(9);
        while (run) {
            if (checkForWin()) {
                boardPrint();
                System.out.println("You won.");
                run = false;
            }
            boardPrint();
            chooseMode(stringInput("Place flag or mine (f/m)"), intInput("At what x coordinate (0-8)"), intInput("At what y coordinate (0-8)"));
            checkForLose();
            if (checkForWin()) {
                // won
                boardPrint();
                System.out.println("You won.");
                run = false;
            }
        }
    }

    public static boolean checkForWin() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mines[i][j] != flags[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void checkForLose() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mines[i][j] && mined[i][j]) {
                    System.out.println("You lost.");
                    run = false;
                    break;
                }
            }
        }
    }

    public static String stringInput(String message) {
        System.out.println(message);
        input.nextLine();
        String character = input.nextLine();
        return character;
    }

    public static int intInput(String message) {
        System.out.println(message);
        int number = input.nextInt();
        return number;
    }

    public static boolean[][] boardGen(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int r = rand.nextInt(100);
                if (r == 1 || r == 1) {
                    mines[i][j] = true;
                }
            }
        }
        return mines;
    }

    public static void boardPrint() {
        System.out.print("  ");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = 0; i < mines.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < mines[i].length; j++) {
                //System.out.print(checkSurrounding(j, i, mines) + " ");

                if (mines[j][i]) {
                    System.out.print("M ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
    }

    public static void chooseMode(String m, int x, int y) {
        if (m.equals("f")) {
            if (flags[y][x]) {
                flags[y][x] = false;
            } else {
                flags[y][x] = true;
            }
        }
        if (m.equals("m")) {
            mined[y][x] = true;
        }
    }

    // DO
    public static int checkSurrounding(int xC, int yC, boolean[][] mines) {
        int count = 0;

        //System.out.print(count);
        return count;
    }
}
