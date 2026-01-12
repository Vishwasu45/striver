package basic.basicStrings;

public class PalindromeCheck {

    public static void main(String[] args) {

        PalindromeCheck solution = new PalindromeCheck();
        String s = "racecar"; // Example input
        System.out.println("Is \"" + s + "\" a palindrome? " + solution.palindromeCheck(s));
    }

    public boolean palindromeCheck(String s) {
        // your code goes here
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return s.equals(new String(arr));
    }

    public boolean palindromeCheckStriverEditorial(String s) {
        int left = 0;
        int right = s.length() - 1;

        // Iterate while start pointer is less than end pointer
        while (left < right) {
            // If characters don't match, it's not a palindrome
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
