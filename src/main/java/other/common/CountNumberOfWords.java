package other.common;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfWords {

    public static void main(String[] args) {
        CountNumberOfWords counter = new CountNumberOfWords();
        String input = "hello world hello";
        Map<String, Integer> result = counter.countWords(input);
        System.out.println("Word counts: " + result);
    }

    public Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}
