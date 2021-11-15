package November_December;

/**
 *
 * @author Ethan
 */
public class MethodsPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        p("Hello World");
        printFactors(10);
        p(areaRect(5, 5) + "");
    }
    
    public static double areaRect(double w, double l){
        return w * l;
    }

    public static void printFactors(int n) {
        System.out.println("The factors of " + n + " are:");
        // from 1 to n
        for (int i = 1; i <= n; i++) {
            //does n divide by i
            if (n % i == 0) {
                // print result
                p(i + "");
            }
        }
    }

    public static void p(String s) {
        System.out.println(s);
    }
}
