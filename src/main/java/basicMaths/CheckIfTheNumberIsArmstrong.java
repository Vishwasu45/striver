package basicMaths;

public class CheckIfTheNumberIsArmstrong {

    public static void main(String[] args) {
        int n = 153;
        boolean isArmstrong = isArmstrong(n);
        if (isArmstrong) {
            System.out.println(n + " is an Armstrong number.");
        } else {
            System.out.println(n + " is not an Armstrong number.");
        }
    }

    public static boolean isArmstrong(int n) {
        if (n == 0) return true;
        int sum = 0;
        int duplicate = n;
        int count = (int)Math.log10(n) + 1;
        while(n > 0) {
            int remainder = n % 10;
            sum = sum + (int)Math.pow(remainder, count);
            n = n / 10;
        }
        return duplicate == sum;
    }
}
