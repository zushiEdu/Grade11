package MainFiles;

import java.util.Scanner;

/**
 *
 * @author etho8
 */
public class PlayerConsoleMovement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int y = 1;
        int x = 1;

        int mapSize = 5;

        int playerX = 1;
        int playerY = 1;

        String instruction;

        Scanner input = new Scanner(System.in);

        while (true) {
            // print mapSize rows
            while (y <= mapSize) {
                // print mapSize collums
                while (x <= mapSize) {
                    // if the current blocks x and y are matching with the players
                    if (x == playerX && y == playerY) {
                        // print the player in this code but add a M next to it if this current block is the middle block
                        if (x == (mapSize / 2) + 1 && y == (mapSize / 2) + 1) {
                            System.out.print("[PM]");
                        } else {
                            System.out.print("[PO]");
                        }
                    } else {
                        // print normal blocks but add m to second slot when the current block is the middle block
                        if (x == mapSize / 2 + 1 && y == mapSize / 2 + 1) {
                            System.out.print("[OM]");
                        } else {
                            System.out.print("[OO]");
                        }
                    }
                    // increase collum
                    x++;
                }
                // increase row, reset collum and shift to next line
                y++;
                System.out.println("");
                x = 1;
            }
            // record next instruction
            instruction = input.nextLine();

            // reset row
            y = 1;

            // chance location of player
            if (instruction.equals("right")) {
                if (playerX < mapSize) {
                    playerX++;
                } else if (playerX == mapSize){
                    System.out.println("Invalid Command");
                }
            } else if (instruction.equals("left")) {
                if (playerX > 1) {
                    playerX--;
                } else if (playerX == 1){
                    System.out.println("Invalid Command");
                }
            } else if (instruction.equals("up")) {
                if (playerY > 1) {
                    playerY--;
                } else if (playerY == 1){
                    System.out.println("Invalid Command");
                }
                playerY--;
            } else if (instruction.equals("down")) {
                if (playerY < mapSize) {
                    playerY++;
                } else if (playerY == mapSize){
                    System.out.println("Invalid Command");
                }
            }
        }
    }
}
