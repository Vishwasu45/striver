package basicmaths;

public class LCMofTwoNumbers {

    public static void main(String[] args) {

        LCMofTwoNumbers lcmCalculator = new LCMofTwoNumbers();
        int n1 = 12;
        int n2 = 15;
        int lcm = lcmCalculator.LCM(n1, n2);
        System.out.println("LCM of " + n1 + " and " + n2 + " is: " + lcm);
    }

    public int LCM(int n1, int n2) {
        return (n1 * n2) / GCD(n1, n2);
    }

    public int GCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return GCD(n2, n1 % n2);
    }
}
