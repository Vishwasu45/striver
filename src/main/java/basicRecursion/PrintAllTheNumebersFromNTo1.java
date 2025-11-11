package basicRecursion;

public class PrintAllTheNumebersFromNTo1 {

    public static void main(String[] args) {
        PrintAllTheNumebersFromNTo1 obj = new PrintAllTheNumebersFromNTo1();
        int n = 5;
        obj.printNumbersTailRecursion(n);
        System.out.println("-----");
        obj.printNumbersHeadRecursion(1, n);
    }

    public void printNumbersTailRecursion(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumbersTailRecursion(n - 1);
    }

    // Head recursion to print from N to 1
    public void printNumbersHeadRecursion(int i, int n) {
        // Base case
        if (i > n) {
            return;
        }
        printNumbersHeadRecursion(i + 1, n);
        System.out.println(i);
    }
}
