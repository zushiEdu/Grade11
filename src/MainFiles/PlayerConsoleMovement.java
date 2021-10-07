package MainFiles;

import java.util.Scanner;

/**
 *
 * @author ethan
 */
public class PlayerConsoleMovement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input_Int = new Scanner(System.in);
        Scanner input_String = new Scanner(System.in);

        int y = 1;
        int x = 1;

        System.out.println("Enter desired map size.");

        int mapSize;
        mapSize = input_Int.nextInt();
        //mapSize = 5;

        int playerX = 1;
        int playerY = 1;

        String instruction;

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

            // reset row
            y = 1;

            // record next instruction
            System.out.println("Enter instrction.");
            instruction = input_String.nextLine();

            // change location of player but stops player before it goes off the edge
            if (instruction.equals("d")) {
                // command to move player right
                if (playerX < mapSize) {
                    playerX++;
                } else if (playerX == mapSize) {
                    System.out.println("Invalid Command");
                }
            } else if (instruction.equals("a")) {
                // command to move player left
                if (playerX > 1) {
                    playerX--;
                } else if (playerX == 1) {
                    System.out.println("Invalid Command");
                }
            } else if (instruction.equals("w")) {
                // command to move player up
                if (playerY > 1) {
                    playerY--;
                } else if (playerY == 1) {
                    System.out.println("Invalid Command");
                }
            } else if (instruction.equals("s")) {
                // command to move player down
                if (playerY < mapSize) {
                    playerY++;
                } else if (playerY == mapSize) {
                    System.out.println("Invalid Command");
                }
            } else if (instruction.equals("msc")) {
                // command to change map size
                System.out.println("Enter New Map Size");
                mapSize = input_Int.nextInt();
                if (playerX <= mapSize && playerY >= mapSize) {
                    // if only y axis is off bounds
                    playerY = mapSize;
                } else if (playerX >= mapSize && playerY <= mapSize) {
                    // if only x axis is off bounds
                    playerX = mapSize;
                } else if (playerX >= mapSize && playerY >= mapSize) {
                    // if both axis are off bounds
                    playerY = mapSize;
                    playerX = mapSize;
                }
            } else {
                System.out.println("Invalid Command");
            }
            
            System.out.print("\033[H\033[2J");
            System.out.flush(); 
        }
    }
}
