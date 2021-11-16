/*
 * Developed by Ethan Huber
 * Year of 2021 grade 11
 * Feel free to copy, redistribute and use
 */
package November_December;

import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    // game setup
    static char[] board = new char[9];
    static Scanner input = new Scanner(System.in);
    static char player = 'X';

    public static void main(String[] args) {
        clearBoard();
        while (true) {
            drawBoard();
            placePiece();
            boolean tie = checkForWin();
            boolean win = checkForTie();
            if (win || tie) {
                System.out.println("Player " + player + " won.");
                break;
            } else {
                changeTurn();
            }
        }
    }

    public static boolean checkForTie() {
        for (int i = 0; i < board.length; i++) {
            if (isClear(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[3 * i] == player && board[3 * i + 1] == player && board[3 * i + 2] == player) {
                // player won across
                return true;
            }

            if (board[i] == player && board[3 + i] == player && board[6 + i] == player) {
                // player won across the other way
                return true;
            }
        }

        if (board[2] == player && board[4] == player && board[6] == player) {
            // player won horizontal
            return true;
        }

        if (board[4] == player && board[8] == player && board[0] == player) {
            // player won horizontal
            return true;
        }

        // after all possible checks return false
        return false;
    }

    public static void changeTurn() {
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }
    }

    public static void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            String number =  i + "";
            board[i] = (char) number.charAt(0);
        }
    }

    public static boolean isClear(int spot) {
        if (board[spot] != 'X' && board[spot] != 'O') {
            return true;
        } else {
            return false;
        }
    }

    public static void placePiece() {
        System.out.println("It is " + player + "'s turn");
        System.out.println("Pick a spot from 0 to 8");
        int place = input.nextInt();

        while (!(isClear(place))) {
            System.out.println("That spot is taken. Try again");
            place = input.nextInt();
        }

        board[place] = player;
    }

    public static void drawBoard() {
        // draw 3 rows
        System.out.println(board[0] + "|" + board[1] + "|" + board[2]);
        System.out.println("-+-+-");
        System.out.println(board[3] + "|" + board[4] + "|" + board[5]);
        System.out.println("-+-+-");
        System.out.println(board[6] + "|" + board[7] + "|" + board[8]);
    }

    public static void testBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i] + " ");
        }
        System.out.println("");
    }
}
