package basic.basicStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "eat";
        String t = "tea";
        System.out.println(va.anagramStringsMine(s, t));
    }

    public boolean anagramStringsMine(String s, String t) {
        // your code goes here
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Sort the maps by key
        sMap = new HashMap<>(sMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new)));
        tMap = new HashMap<>(tMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new)));

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!tMap.containsKey(entry.getKey()) || !tMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean anagramStringsStriverEditorialBruteForce(String s, String t) {
        // If lengths are not equal, they cannot be anagrams
        if (s.length() != t.length())
            return false;

        // Convert strings to char arrays and sort them
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Compare sorted arrays
        return Arrays.equals(sArray, tArray);
    }

    public boolean anagramStringsStriverEditorialOptimal(String s, String t) {
        // Edge Cases
        if (s.length() != t.length())
            return false;

        // To store the count of each character
        int[] count = new int[26];

        // Count occurrence of each character in first string
        for (char c : s.toCharArray())
            count[c - 'a']++;

        // Decrement the count for each character in the second string
        for (char c : t.toCharArray())
            count[c - 'a']--;

        // Check for count of every character
        for (int i : count) {
            // If the count is not zero
            if (i != 0)
                return false; // Return false
        }

        // Otherwise strings are anagram
        return true;
    }
}
