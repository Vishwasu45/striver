package basic.basicRecursion;

public class PalindromeCheck {

    public static void main(String[] args) {
        PalindromeCheck pc = new PalindromeCheck();
        String s = "racecar";
        System.out.println(pc.palindromeCheck(s));
    }

    public boolean palindromeCheck(String s) {
        // your code goes here
        return check(s, 0, s.length() - 1);
    }

    private boolean check(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return check(s, left + 1, right - 1);
    }
}
