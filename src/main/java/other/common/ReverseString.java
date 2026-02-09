package other.common;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverser = new ReverseString();
        String original = "Hello, World!";
        String reversed = reverser.reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }

    public String reverseString(String input) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
