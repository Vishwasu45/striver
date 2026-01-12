package basic.basicStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        SortCharactersByFrequency scbf = new SortCharactersByFrequency();
        String s = "mmmmmmmmmmnnnnnnnnnooooooooopppppppppqqqqqqqqqrrrrrrrrr";
        System.out.println(scbf.frequencySort(s));
    }

    public List<Character> frequencySort(String s) {
        // Your code goes here
        Map<Character, Integer> frequencyMap = new java.util.HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        Character[] characters = frequencyMap.keySet().toArray(new Character[0]);
        // Sort the array based on the decreasing order of frequency and increasing
        // order of character if the frequency is same
        Arrays.sort(characters, (a, b) -> {
            int freqCompare = Integer.compare(frequencyMap.get(b), frequencyMap.get(a));
            if (freqCompare == 0) {
                return Character.compare(a, b);
            }
            return freqCompare;
        });
        return Arrays.asList(characters);
    }

    public List<Character> frequencySortStriverEditorial(String s) {
        // Frequency array for characters 'a' to 'z'
        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char) (i + 'a'));
        }

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        // Sort based on frequency (descending) and alphabetically (ascending)
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq)
                return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });

        // Collect result
        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0)
                result.add(p.ch);
        }
        return result;
    }

    // Helper class to store frequency and character
    static class Pair {
        int freq;
        char ch;

        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }
}
