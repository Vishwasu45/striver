package basicStrings;

public class RotateString {

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        String s = "abcde";
        String goal = "cdeab";
        boolean result = rs.rotateString(s, goal);
        System.out.println("Result: " + result);

        boolean resultEditorial = rs.rotateStringStriverEditorial(s, goal);
        System.out.println("Result (Striver Editorial): " + resultEditorial);

        boolean resultOptimized = rs.rotateStringOptimized(s, goal);
        System.out.println("Result (Optimized): " + resultOptimized);
    }

    public boolean rotateString(String s, String goal) {
        //your code goes here
        if (s.equals(goal)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            char[] charArray = s.toCharArray();
            char firstChar = charArray[0];
            for (int j = 0; j < charArray.length - 1; j++) {
                charArray[j] = charArray[j + 1];
            }
            charArray[charArray.length - 1] = firstChar;
            s = String.valueOf(charArray);
            if (s.equals(goal)) {
                return true;
            }
        }

        return false;
    }

    public boolean rotateStringStriverEditorial(String s, String goal) {
        // Strings must be same length to be rotations of each other
        if (s.length() != goal.length()) {
            return false;
        }
        // Try all possible rotations of s
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) {
                return true;  // Return true if a match is found
            }
        }
        return false;
    }

    public boolean rotateStringOptimized(String s, String goal) {
        // Strings must be same length to be rotations of each other
        if (s.length() != goal.length()) {
            return false;
        }
        // Concatenate s with itself
        String concatenated = s + s;
        // Check if goal is a substring of the concatenated string
        return concatenated.contains(goal);
    }
}
