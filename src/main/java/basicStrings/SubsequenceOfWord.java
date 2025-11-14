package basicStrings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsequenceOfWord {

    public static void main(String[] args) {
        SubsequenceOfWord obj = new SubsequenceOfWord();
        String s = "abcde";
        String[] words = {"a", "ea", "acd", "ace"};
        System.out.println(obj.getSubSequenceCount(s, words));
    }

    public int getSubSequenceCount(String s, String[] words) {
        char[] sChars = s.toCharArray();
        int count = 0;
        for (String word : words) {
            Map<Character, List<Integer>> charIndexMap = new HashMap<>();
            for (int i = 0; i < sChars.length; i++) {
                charIndexMap.computeIfAbsent(sChars[i], k -> new java.util.ArrayList<>()).add(i);
            }
            char[] wchars = word.toCharArray();
            for (int i = 0; i < wchars.length; i++) {
                if (charIndexMap.containsKey(wchars[i]) && !charIndexMap.get(wchars[i]).isEmpty()) {
                    charIndexMap.get(wchars[i]).remove(0);
                    if (i == wchars.length - 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
