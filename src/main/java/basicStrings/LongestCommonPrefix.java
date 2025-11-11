package basicStrings;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] str = {"flowers" , "flow" , "fly", "flight"}; // Example input
        System.out.println("Longest Common Prefix: " + solution.longestCommonPrefix(str));
        System.out.println("Longest Common Prefix (Striver): " + solution.longestCommonPrefixStriverEditorial(str));
    }

    public String longestCommonPrefix(String[] str) {
        //your code goes here
        String[] sortedArray = Arrays.stream(str).sorted().toArray(String[]::new);
        String first = sortedArray[0];
        String last = sortedArray[sortedArray.length - 1];
        String longestCommonPrefix = "";
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                longestCommonPrefix += first.charAt(i);
            } else {
                break;
            }
        }
        return longestCommonPrefix;
    }

    // Method to find the longest common prefix in an array of strings
    public String longestCommonPrefixStriverEditorial(String[] v) {
        // Use StringBuilder to build the result
        StringBuilder ans = new StringBuilder();

        // Sort the array to get the lexicographically smallest and largest strings
        Arrays.sort(v);
        // First string (smallest in sorted order)
        String first = v[0];
        // Last string (largest in sorted order)
        String last = v[v.length - 1];

        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // If characters don't match, return the current prefix
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            // Append the matching character to the result
            ans.append(first.charAt(i));
        }

        // Return the longest common prefix found
        return ans.toString();
    }
}
