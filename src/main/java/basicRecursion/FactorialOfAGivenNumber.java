package basicRecursion;

public class FactorialOfAGivenNumber {

    public static void main(String[] args) {
        FactorialOfAGivenNumber solution = new FactorialOfAGivenNumber();
        int N = 5; // Example input
        System.out.println("Factorial of " + N + " is " + solution.factorial(N));
    }

    public long factorial(int n) {
        //your code goes here
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
