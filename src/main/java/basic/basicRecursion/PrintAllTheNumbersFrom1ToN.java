package basic.basicRecursion;

public class PrintAllTheNumbersFrom1ToN {

    public static void main(String[] args) {
        PrintAllTheNumbersFrom1ToN obj = new PrintAllTheNumbersFrom1ToN();
        int n = 5;
        obj.printNumbersTailRecursion(1, n);
        System.out.println("-----");
        obj.printNumbersHeadRecursion(n);
    }

    public void printNumbersTailRecursion(int current, int n) {
        // Base case
        if (current > n) {
            return;
        }
        System.out.println(current);
        printNumbersTailRecursion(current + 1, n);
    }

    public void printNumbersHeadRecursion(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        printNumbersHeadRecursion(n - 1);
        System.out.println(n);
    }
}
