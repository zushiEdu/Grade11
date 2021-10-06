package MainFiles;

import java.util.Random;

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

        int mapSize = 17;

        int spawnChanceX = 0;
        int spawnChanceY = 0;

        Random random;

        while (y <= mapSize) {
            while (x <= mapSize) {

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
                if (x == mapSize / 2 && y == mapSize / 2) {
                    // Print middle block if currect index is the middle block here
                    System.out.print("M ");
                } else {
                    // Print block here 'mapSize^2' times
                    System.out.print("[" + spawnChanceX + "," + spawnChanceY + "]");

                    float spawnChanceXFloat = spawnChanceX;
                    float spawnChanceYFloat = spawnChanceY;
                    
                    float xFraction = 5 / spawnChanceXFloat;
                    float yFraction = 5 / spawnChanceYFloat;

                    //System.out.print("[" + xFraction + "," + yFraction + "]");
                    
                    if (xFraction > 0.75 && yFraction > 0.75){
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                }
                x++;
            }
            y++;
            System.out.println("");
            x = 1;
        }
    }
}
