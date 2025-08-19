package basicpatterns;

public class Pattern18 {

    /*
    D 
    C D 
    B C D 
    A B C D 
    */

    public static void main(String[] args) {
        Pattern18 pattern = new Pattern18();
        int n = 4; // Example size of the pattern
        pattern.printPattern(n);
    }

    public void printPattern(int n) {
        for(int i = 1; i <= n; i++) {
            for(char ch = (char)('A' + (n - i)); ch <= (char)('A' + n - 1); ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    
}
