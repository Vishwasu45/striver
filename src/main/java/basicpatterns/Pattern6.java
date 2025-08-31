package basicpatterns;

public class Pattern6 {

    /*
     12345
     1234
     123
     12
     1
     */

    public static void main(String[] args) {
        Pattern6 pattern = new Pattern6();
        int n = 5; // Example size of the pattern
        pattern.pattern6(n);
    }

    public void pattern6(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n-i ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
