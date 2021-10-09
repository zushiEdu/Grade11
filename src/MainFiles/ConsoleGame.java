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

        // sets default location
        int playerX = 1;
        int playerY = 1;

        int playerHealth = 1;

        // sets character and mapData
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

        // master game loop
        while (run) {
            // prints health
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

            // prints location of player
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
                        // extracts mapData
                        bI = mapData[in] / 100;
                        bX = mapData[in] / 10 - (mapData[in] / 100) * 10;
                        bY = mapData[in] - mapData[in] / 10 * 10;
                        if (bX == x && bY == y) {
                            stopState = true;
                        } else {
                            in++;
                        }
                    }

                    // print block with corrosponding information
                    if (bX == x && bY == y) {
                        System.out.print(chars[bI] + " ");
                    } else if (playerX == x && playerY == y) {
                        System.out.print("P ");
                    } else {
                        System.out.print("O ");
                    }

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

            // prints toolbar and itembar
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

            } else if (instruction.equals("stop") || instruction.equals("exit")) {
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

                        // removes block from database
                        while (loop < mapData.length) {
                            if (index + loop < mapData.length) {
                                // if block isn't the top of the database
                                mapData[index] = mapData[index + loop];
                            } else {
                                // if block is the top of the database
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
                // use block to the right
                int index = 0;
                boolean stopConditon = false;
                while (index < mapData.length && stopConditon == false) {
                    if (mapData[index] - mapData[index] / 100 * 100 == (playerX + 1) * 10 + playerY) {
                        // if there is a block to the right
                        if (mapData[index] / 100 == 3) {
                            //if block to the right is a crafting bench
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
                // prints invalid command when command entered is invalid
                System.out.println("Invalid Command");
            }

            // clears console after every loop but doesn't work currently
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}