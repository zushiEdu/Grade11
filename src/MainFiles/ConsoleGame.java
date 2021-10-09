package MainFiles;

import java.util.Scanner;

/**
 *
 * @author ethan
 */
public class ConsoleGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input_Int = new Scanner(System.in);
        Scanner input_String = new Scanner(System.in);

        int y = 1;
        int x = 1;

        // comment out lines for input to make map size or preset map size
        //System.out.println("Enter desired map size.");
        int mapSize;
        //mapSize = input_Int.nextInt();
        mapSize = 9;

        int playerX = 1;
        int playerY = 1;

        int playerHealth = 1;

        String[] chars = {"?", "W", "D", "C"};
        int[] mapData = {125, 233, 242, 253, 162, 173, 182, 399};

        String[] tb = {"  ", "  ", "  "};
        int[] inv = {0, 0};

        int in = 0;

        int bI = mapData[in] / 100;
        int bX = mapData[in] / 10 - (mapData[in] / 100) * 10;
        int bY = mapData[in] - mapData[in] / 10 * 10;

        boolean stopState = false;

        String instruction;

        boolean run = true;

        while (run) {
            // sample health and location bar
            // [HEA:][<3][<3][<3][LOC:][009,009]
            // prints health and location
            System.out.print("[HEA:]");

            int i = 1;
            while (i <= playerHealth) {
                System.out.print("[<3]");
                i++;
            }
            if (playerHealth <= 3) {
                while (i <= 3) {
                    System.out.print("[<>]");
                    i++;
                }
            }

            System.out.print("[LOC:]");
            System.out.println("[00" + playerX + ",00" + playerY + "]");
            System.out.println("[+----- 1 2 3 4 5 6 7 8 9 -----+]");
            System.out.print("[|                             |]");

            System.out.println("");

            //System.out.print(chars[bI] + " ");
            // print mapSize rows
            while (y <= mapSize) {
                System.out.print("[" + y + "      ");
                // print mapSize collums
                while (x <= mapSize) {

                    in = 0;
                    stopState = false;
                    while (stopState == false && in < mapData.length) {
                        bI = mapData[in] / 100;
                        bX = mapData[in] / 10 - (mapData[in] / 100) * 10;
                        bY = mapData[in] - mapData[in] / 10 * 10;
                        if (bX == x && bY == y) {
                            stopState = true;
                        } else {
                            in++;
                        }
                    }

                    // print block now
                    if (bX == x && bY == y) {
                        System.out.print(chars[bI] + " ");
                    } else if (playerX == x && playerY == y) {
                        System.out.print("P ");
                    } else {
                        System.out.print("O ");
                    }

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
                System.out.print("     " + y + "]");
                y++;
                System.out.println("");
                x = 1;
            }
            // reset row
            y = 1;

            System.out.println("[|                             |]");
            System.out.println("[+----- 1 2 3 4 5 6 7 8 9 -----+]");

            System.out.print("[TO:]" + "[" + tb[0] + "]" + "[" + tb[1] + "]" + "[" + tb[2] + "]" + "[ITE:]" + "[");
            if (inv[0] < 10) {
                System.out.print("0" + inv[0] + "W");
            }
            System.out.print("][");
            if (inv[1] < 10) {
                System.out.print("0" + inv[1] + "D]");
            }
            System.out.println("");

            // record next instruction
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

                /*
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
                 */
                System.out.println("Disabled Command");

            } else if (instruction.equals("stop")) {
                run = false;
            } else if (instruction.equals("mr")) {
                // mine block to the right
                int index = 0;
                int loop = 0;
                while (index < mapData.length) {
                    // search through mapData
                    if (mapData[index] - mapData[index] / 100 * 100 == (playerX + 1) * 10 + playerY) {
                        // found matching block to the right

                        // add block to inventory
                        if (mapData[index] / 100 == 1) {
                            // add one to dirt value if amount of mapData sets are less than or equal to one
                            if (inv[0] + inv[0] + 1 <= inv[0] + inv[0] + 1) {
                                inv[0] = inv[0] + 1;
                            }
                        } else if (mapData[index] / 100 == 2) {
                            // add one to wood value if amount of mapData sets are less than or equal to one
                            if (inv[1] + inv[1] + 1 <= inv[1] + inv[1] + 1) {
                                inv[1] = inv[1] + 1;
                            }
                        }

                        while (loop < mapData.length) {
                            if (index + loop < mapData.length) {
                                mapData[index] = mapData[index + loop];
                            } else {
                                mapData[index] = 0;
                            }
                            loop++;
                        }
                        loop = 1;
                    }
                    index++;
                }
            } else if (instruction.equals("ml")) {
                // mine block to the left
                int index = 0;
                int loop = 0;
                while (index < mapData.length) {
                    // search through mapData
                    if (mapData[index] - mapData[index] / 100 * 100 == (playerX - 1) * 10 + playerY) {
                        // found matching block

                        // add block to inventory
                        if (mapData[index] / 100 == 1) {
                            // add one to dirt value if amount of mapData sets are less than or equal to one
                            if (inv[0] + inv[0] + 1 <= inv[0] + inv[0] + 1) {
                                inv[0] = inv[0] + 1;
                            }
                        } else if (mapData[index] / 100 == 2) {
                            // add one to wood value if amount of mapData sets are less than or equal to one
                            if (inv[1] + inv[1] + 1 <= inv[1] + inv[1] + 1) {
                                inv[1] = inv[1] + 1;
                            }
                        }

                        // replace the data
                        // get the data from one above and shift it down
                        // if data is at the top change it to zero
                        while (loop < mapData.length) {
                            if (index + loop < mapData.length) {
                                mapData[index] = mapData[index + loop];
                            } else {
                                mapData[index] = 0;
                            }
                            loop++;
                        }
                        loop = 1;
                    }
                    index++;
                }
            } else if (instruction.equals("er")) {
                int index = 0;
                boolean stopConditon = false;
                while (index < mapData.length && stopConditon == false) {
                    if (mapData[index] - mapData[index] / 100 * 100 == (playerX + 1) * 10 + playerY) {
                        // if there is a block to the right
                        if (mapData[index] / 100 == 3) {
                            //this is a crafting bench
                            //open up crafting screen
                            System.out.println("Type item to craft");
                            String item = input_String.nextLine();
                            if (item.equals("axe")) {
                                if (inv[0] >= 2) {
                                    tb[0] = "AX";
                                    System.out.println("Axe Was Crafted.");
                                    inv[0] = inv[0] - 2;
                                    stopConditon = true;
                                } else {
                                    System.out.println("Not enough wood.");
                                    stopConditon = true;
                                }
                            } else if (item.equals("dirt cake")) {
                                if (inv[1] >= 1) {
                                    playerHealth++;
                                    System.out.println("A Dirt Cake Was Crafted and Consumed.");
                                    inv[1] = inv[1] - 1;
                                    stopConditon = true;
                                } else {
                                    System.out.println("Not enough dirt.");
                                    stopConditon = true;
                                }
                            } else {
                                System.out.println("Invalid Item Code.");
                                stopConditon = true;
                            }
                        } else {
                            System.out.println("Was not crafting bench");
                            stopConditon = true;
                        }
                    }
                    index++;
                }
            } else {
                System.out.println("Invalid Command");
            }

            // clears console after every loop
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
