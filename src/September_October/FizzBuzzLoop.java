package September_October;

/**
 *
 * @author hubee8329
 */
public class FizzBuzzLoop {

    public static void main(String[] args) {

        int index = 0;

        while (index < 101) {
            if ((index % 15) == 0) {
                System.out.println(index + ", FizzBuzz");
            } else if ((index % 5) == 0) {
                System.out.println(index + ", Buzz");
            } else if ((index % 3) == 0) {
                System.out.println(index + ", Fizz");
            } else {
                System.out.println(index);
            }
            index = index + 1;
        }
    }

}
