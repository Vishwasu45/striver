package basicRecursion;

public class SumOfFirstNNumbers {

    public static void main(String[] args) {
        SumOfFirstNNumbers solution = new SumOfFirstNNumbers();
        int N = 10; // Example input
        System.out.println("Sum of first " + N + " numbers is " + solution.NnumbersSum(N));
    }

    public int NnumbersSum(int N) {
        //your code goes here
        if (N == 0) {
            return 0;
        }
        return N + NnumbersSum(N - 1);
    }
}
