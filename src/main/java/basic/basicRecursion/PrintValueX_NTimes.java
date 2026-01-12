package basic.basicRecursion;

public class PrintValueX_NTimes {

    public static void main(String[] args) {
        PrintValueX_NTimes obj = new PrintValueX_NTimes();
        int x = 5;
        int n = 3;
        obj.printXTimes(x, n);
    }

    public void printXTimes(int x, int n) {
        // Base case
        if (n == 0) {
            return;
        }
        System.out.println(x);
        printXTimes(x, n - 1);
    }
}
