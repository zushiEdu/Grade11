package September_October;

import java.util.Scanner;

/**
 *
 * @author etho8
 */
public class JuniorChallenge {

    public static void main(String[] args) {
        //1. Disect the number, first two number is the instruction, anything else is the amount of steps to do (57234 would be right 234)
        //2. If the sum of the first two numbers is odd the direction is left
        //3. If the sum is even and not zero the direction is right
        //4. If the sum is zero the instruction is the same as the last one
        //5. 99999 is a stop code

        //Sample inputs are: 57234, 00907, 34100, 99999
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Instruction");

        int code = input.nextInt();

        int splitCodeFirst = code / 10000;
        int splitCodeSecond = (code - (code / 10000) * 10000) / 1000;
        int splitCodeFull = (splitCodeFirst * 10000) + (splitCodeSecond * 1000);

        String lastInstruction = null;

        boolean stopProgram = false;

        //System.out.println((splitCodeFirst + splitCodeSecond) % 2);
        //System.out.println(splitCodeFirst + splitCodeSecond);
        while (stopProgram == false) {
            if (code == 99999) {
                //Stop program
                System.out.println("Shutting Down.");
                stopProgram = true;
            } else if ((splitCodeFirst + splitCodeSecond) % 2 == 0 && splitCodeFirst + splitCodeSecond != 0 && stopProgram == false) {
                //Sum of first two numbers is even and not zero
                System.out.println("right " + (code - splitCodeFull));
                lastInstruction = "right";
            } else if ((splitCodeFirst + splitCodeSecond) != 0 && stopProgram == false && splitCodeFirst + splitCodeSecond % 2 != 0) {
                //Sum of first two numbers is odd and not zero
                System.out.println("left " + (code - splitCodeFull));
                lastInstruction = "left";
            } else if (stopProgram == false && splitCodeFirst + splitCodeSecond == 0) {
                //Sum of first two numbers is zero
                System.out.println(lastInstruction + " " + (code - (splitCodeFull * 10000)));
            }
            if (stopProgram == false) {
                //System.out.println("Enter New Instruction");
                code = input.nextInt();

                splitCodeFirst = code / 10000;
                splitCodeSecond = (code - (code / 10000) * 10000) / 1000;
                splitCodeFull = (splitCodeFirst * 10000) + (splitCodeSecond * 1000);
            }
        }
    }
}
