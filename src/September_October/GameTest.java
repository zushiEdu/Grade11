package September_October;

import java.util.Scanner;

/**
 *
 * @author ethan
 */
public class GameTest {

    /**
     * @param args the command line arguments
     */
    //Refresh screen every time an input is pressed
    //Wait for input
    //Create island
    //Movement
    //Placement
    public static void main(String[] args) {
        int y = 1;
        int x = 1;

        int mapSize = 5;

        int spawnChanceX = 0;
        int spawnChanceY = 0;

        Scanner input = new Scanner(System.in);
        int pInput = 22;

        while (true) {
            while (y < mapSize) {
                while (x < mapSize) {

                    // Calculate spawn chance for y axis
                    if (y > mapSize / 2) {
                        spawnChanceY = (y % mapSize / 2);
                    } else if (y < mapSize / 2) {
                        spawnChanceY = (mapSize / 2 - y % mapSize / 2);
                    }

                    if (spawnChanceY == 0) {
                        spawnChanceY = mapSize / 2;
                    }

                    // Calculate spawn chance for x axis
                    if (x > mapSize / 2) {
                        spawnChanceX = (x % mapSize / 2);
                    } else if (x < mapSize / 2) {
                        spawnChanceX = (mapSize / 2 - x % mapSize / 2);
                    }

                    if (spawnChanceX == 0) {
                        spawnChanceX = mapSize / 2;
                    }

                    // Prints block with corrosponding data
                    if (x == mapSize / 2 + 1 && y == mapSize / 2 + 1) {
                        if (x == (pInput / 10) && y == (pInput - ((pInput / 10) * 10))) {
                            System.out.println("[P]");
                        } else {
                            // Print middle block if currect index is the middle block here
                            System.out.print("[M]");
                        }
                    } else {
                        // Print block here 'mapSize^2' times
                        //System.out.print("[" + spawnChanceX + "," + spawnChanceY + "]");

                        if (x == (pInput / 10) && y == (pInput - ((pInput / 10) * 10))) {
                            System.out.println("[P]");
                        } else {
                            System.out.print("[O]");
                        }

                        float spawnChanceXFloat = spawnChanceX;
                        float spawnChanceYFloat = spawnChanceY;

                        float type = spawnChanceYFloat * spawnChanceXFloat;

                        //System.out.print("[" + type + "]");
                        //System.out.print("[" + xFraction * yFraction + "]");
                        //Square types ■ ▩ □
                        if (type <= 25) {
                            // if type is smaller than 30 make block green
                            //System.out.print("\u001B[32m■ ");
                        }
                        if (type > 25 && type < 40) {
                            // if type is biger than 30 and smaller than 40 make block yellow
                            //System.out.print("\u001B[33m■ ");
                        }
                        if (type >= 40) {
                            // if type is bigger than 40 and smaller than infinity
                            //System.out.print("\u001B[34m■ ");
                        }
                    }
                    x++;
                }
                y++;
                System.out.println("");
                x = 1;
            }
            pInput = input.nextInt();
        }
    }
}
