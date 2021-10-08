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
                    
                    // TODO: redo block placement loop, check through list of items with 4 digit id
                    // First two numbers is the item id the last two are the location in x, y
                    // Split number in half than half again
                    // 1104 would be 11 modded by 10
                    // 11 modded by 10 would be 1 which is the x
                    // 1104 when 11 * 100 is taken away is 04 which is the id
                    // 11 when 11 modded by 10 is taken away then 1 would be the y
                    
                    // the result of these operations is getting the x, y and id
                    
                    // loop through a list of items and placing them if the selected 
                    // x and y is matching and print the character assigned with it
                    
                    // check to see if brute forcing the check is the easy way of checking
                    
                    // to optimize in the future you would keep a list containing coordinates of chunk lists
                    // chunk lists have meta coordinates which contain items only within that chunk
                    // meta chunking makes relative palcing possible
                    // for example a list could contain 9 chunks
                    // these nine chunks would have their own x and y coordinates so the ninth would be 3, 3
                    // when searching within big map sizes when dividing the current coordinate selected by chunk size
                    // you can identify which chunk to search through instead of searching the whole map
                    // this operation would only be needed if the camera would shift around with the player
                    // shifting camera could be by when on edge and telling player to move into the chunk next to it
                    // the player would switch to the opposite edge of the other chunk keeping the position that isnt changed
                    // the same dividing logic can be used to determine which chunk the game is focused on to determine where to move the player
                    // these optimizations would mean rendering is quicker and the game can fit on a simpler interface
                    // potentially the player could also choose what camera mode to use before or while playing the game
                    // options menu can be an isntruction with the code "set"
                    
                    // health
                    // an example of a full bar would be:
                    // [HP:][<3<3<3<3<3][HU:][C>C>C>C>C>]
                    // an example of an empty bar would be:
                    // [HP:][<><><><><>][HU:]<><><><><>]
                    // remove defining feature when showing value
                    
                    // at bottom of interface you would have two bars
                    // [TO:][PI][SH][AX][IT:][99W][44D][23S]
                    // to: shows tools and it can show items which can be scrolled with instruciton l and r
                    // tools can be saved as slots and selected with numbers 1-3
                    // sword can be replaced with axe, no durability of these tools 
                    // durability could effect damage and have a minumum but also max
                    // tools can be repaired with repair bench
                    // bottom line is instruction input section
                    
                    // map size would now be represented as chunk amount with generation
                    // chunk size would be height of game section within console
                    
                    // game is updated every time a movement instruction is made
                    
                    // 9x9 grid, 4 spacing on each side.
                    
                    // color can be used for elements that would appear better in color
                    // examples of so are hears, map, tools, command area, items and background
                    // a fucntion would eventually want to be made for each element of the map
                    // turning every element into a function makes identification of bugs, and code simplification 
                    
                    // screen mockup
                    
                    // [HEA:][<3][<3][<3][LOC:][009,009]
                    // [+----- 1 2 3 4 5 6 7 8 9 -----+]
                    // [|                             |]
                    // [1      O O O O O O O O O      1]
                    // [2      O O O O O O O O O      2]
                    // [3      O O O O O O O O O      3]
                    // [4      O O O O O O O O O      4]
                    // [5      O O O O O O O O O      5]
                    // [6      O O O O O O O O O      6]
                    // [7      O O O O O O O O O      7]
                    // [8      O O O O O O O O O      8]
                    // [9      O O O O O O O O O      9]
                    // [|                             |]
                    // [+----- 1 2 3 4 5 6 7 8 9 -----+]
                    // [TO:][PI][SH][AX][ITE:][99W][42D]
                    // [NC:]
                    
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
            
            // clears console after every command
            System.out.print("\033[H\033[2J");
            System.out.flush(); 
        }
    }
}
