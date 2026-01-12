package basic.basicpatterns;

public class Pattern5 {

    /*
     *****
     ****
     ***
     **
     *
     */

    public static void main(String[] args) {
        Pattern5 pattern = new Pattern5();
        int n = 5; // Example size of the pattern
        pattern.pattern5(n);
    }

    public void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
