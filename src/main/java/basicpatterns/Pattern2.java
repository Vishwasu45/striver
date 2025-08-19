package basicpatterns;

public class Pattern2 {

    /*
     *
     **
     ***
     ****
     *****
     */

    public static void main(String[] args) {

        Pattern2 pattern = new Pattern2();
        int n = 5; // Example size of the pattern
        pattern.printPattern(n);
    }

    public void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
