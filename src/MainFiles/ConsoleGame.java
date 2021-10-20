package MainFiles;

import java.util.Arrays;
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

        //int y = 1;
        //int x = 1;
        // comment out lines for input to make map size or preset map size
        //System.out.println("Enter desired map size.");
        int mapSize = 9;
        //mapSize = input_Int.nextInt();

        // sets default location
        int playerX = 1;
        int playerY = 1;

        int playerHealth = 1;

        // sets character and mapData
        String[] chars = {"", "W", "D", "C"};
        String[] charColors = {"", "\u001B[33m", "\u001B[33m", "\u001B[34m"};

        String reset = "\u001B[0m";
        String player = "\u001B[34m";

        int[] mapData = {125, 233, 242, 253, 162, 173, 182, 399};

        String[] tb = {"  ", "  ", "  "};
        int[] inv = {0, 0, 0};

        int invPos = 0;

        int in = 0;

        int bI = mapData[in] / 100;
        int bX = mapData[in] / 10 - (mapData[in] / 100) * 10;
        int bY = mapData[in] - mapData[in] / 10 * 10;

        boolean stopState = false;

        String instruction;

        boolean run = true;

        // master game loop
        while (run) {
            // prints health tag
            System.out.print("[HEA:]");

            // prints full hearts
            for (int i = 0; i < playerHealth; i++) {
                System.out.print("[<3]");
            }

            // prints empty hearts
            if (playerHealth < 3) {
                for (int i = 0; i < 3 - playerHealth; i++) {
                    System.out.print("[<>]");
                }
            }

            // prints location of player and some of the user interface
            System.out.print("[LOC:]");
            System.out.println("[00" + playerX + ",00" + playerY + "]");
            System.out.println("[+----- 1 2 3 4 5 6 7 8 9 -----+]");
            System.out.print("[|                             |]");
            System.out.println("");

            // print mapSize rows
            for (int y = 1; y <= mapSize; y++) {
                System.out.print("[" + y + "      ");
                // print mapSize collums
                for (int x = 1; x <= mapSize; x++) {

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
                        System.out.print(charColors[bI] + chars[bI] + " " + reset);
                    } else if (playerX == x && playerY == y) {
                        System.out.print(player + "P " + reset);
                    } else {
                        System.out.print("\u001B[32m" + "O " + reset);
                    }
                }
                // increase row, reset collum and shift to next line
                System.out.print("     " + y + "]");
                System.out.println("");
            }

            System.out.println("[|                             |]");
            System.out.println("[+----- 1 2 3 4 5 6 7 8 9 -----+]");

            // prints toolbar and itembar
            System.out.print("[TO:]" + "[" + tb[0] + "]" + "[" + tb[1] + "]" + "[" + tb[2] + "]" + "[ITE:]" + "[");
            if (inv[0] < 10) {
                System.out.print("0" + inv[invPos] + chars[invPos + 1]);
            }
            System.out.print("][");
            if (inv[1] < 10) {
                System.out.print("0" + inv[invPos + 1] + chars[invPos + 2] + "]");
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
            } else if (instruction.equals("stop") || instruction.equals("exit")) {
                run = false;
            } else if (instruction.equals("mr")) {
                // mine block to the right
                for (int index = 0; index < mapData.length; index++) {
                    // search through mapData
                    if (mapData[index] - mapData[index] / 100 * 100 == (playerX + 1) * 10 + playerY) {
                        // found matching block to the right

                        // add the matching block to the inventory
                        int typeRight = mapData[index] / 100 - 1;
                        inv[typeRight]++;

                        // removes block from database
                        // if data is at the top change it to zero
                        for (int loop = 0; loop < mapData.length; loop++) {
                            if (index + loop < mapData.length) {
                                mapData[index] = mapData[index + loop];
                            } else {
                                mapData[index] = 0;
                            }
                        }
                    }
                }
            } else if (instruction.equals("ml")) {
                // mine block to the left
                for (int index = 0; index < mapData.length; index++) {
                    // search through mapData
                    if (mapData[index] - mapData[index] / 100 * 100 == (playerX - 1) * 10 + playerY) {
                        // found matching block

                        // add the matching block to the inventory
                        int typeLeft = mapData[index] / 100 - 1;
                        inv[typeLeft]++;

                        // replace the data
                        // get the data from one above and shift it down
                        // if data is at the top change it to zero
                        for (int loop = 0; loop < mapData.length; loop++) {
                            if (index + loop < mapData.length) {
                                mapData[index] = mapData[index + loop];
                            } else {
                                mapData[index] = 0;
                            }
                        }
                    }
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
            } else if (instruction.equals("e")) {
                // incrase invPos by one if not at max scroll
                if (invPos < inv.length - 2) {
                    invPos++;
                    System.out.println(invPos);
                }
            } else if (instruction.equals("q")) {
                // decrease invPos by one if not at max scroll
                if (invPos > 0) {
                    invPos--;
                }
            } else if (instruction.equals("p")) {
                int offset = 0;
                boolean validInput = true;
                System.out.println("Which direction? Type r or l only");
                instruction = input_String.nextLine();
                if (instruction.equals("l")) {
                    offset = -1;
                } else if (instruction.equals("r")) {
                    offset = 1;
                } else {
                    System.out.println("This is not a valid input");
                    validInput = false;
                }

                while (validInput) {
                    System.out.println("Which block to place?");
                    instruction = input_String.nextLine();
                    if (instruction.equals("dirt")) {
                        if (inv[1] > 0) {
                            // place block to the right
                            // makes a copy of mapData into newArr with an extra value at the end                
                            int[] newArr = Arrays.copyOf(mapData, mapData.length + offset);

                            mapData = newArr;

                            mapData[mapData.length - 1] = 200 + (playerX + 1) * 10 + playerY * 1;

                            inv[1]--;
                        } else {
                            System.out.println("Not enough dirt");
                            validInput = false;
                        }
                    } else if (instruction.equals("ct")) {
                        if (inv[2] > 0) {
                            // place block to the right
                            // makes a copy of mapData into newArr with an extra value at the end                
                            int[] newArr = Arrays.copyOf(mapData, mapData.length + 1);

                            mapData = newArr;

                            mapData[mapData.length - 1] = 300 + (playerX + 1) * 10 + playerY * 1;

                            inv[2]--;
                        } else {
                            System.out.println("Not enough crafting tables");
                            validInput = false;
                        }
                    } else if (instruction.equals("wood")) {
                        if (inv[0] > 0) {
                            // place block to the right
                            // makes a copy of mapData into newArr with an extra value at the end                
                            int[] newArr = Arrays.copyOf(mapData, mapData.length + 1);

                            mapData = newArr;

                            mapData[mapData.length - 1] = 100 + (playerX + 1) * 10 + playerY * 1;

                            inv[0]--;
                        } else {
                            System.out.println("Not enough wood");
                            validInput = false;
                        }
                    }
                }
            } else {
                // prints invalid command when command entered is invalid
                System.out.println("Invalid Command");
            }

            // clears console after every loop but doesn't work in netbeans
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
