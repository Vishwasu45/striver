package basic.basicpatterns;

public class Pattern1 {

    /*
     *****
     *****
     *****
     *****
     *****
     */

    public static void main(String[] args) {

        Pattern1 pattern = new Pattern1();
        int n = 5; // Example size of the pattern
        pattern.printPattern(n);
    }

    public void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
