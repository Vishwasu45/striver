package basicHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HighestOccurringElementInAnArray {

    public static void main(String[] args) {
        HighestOccurringElementInAnArray obj = new HighestOccurringElementInAnArray();
        int[] nums = {1, 3, 2, 3, 4, 1, 3};
        System.out.println(obj.mostFrequentElement(nums));
        System.out.println(obj.mostFrequentElementStriverBruteForce(nums));
        System.out.println(obj.mostFrequentElementCopilot(nums));
    }

    public int mostFrequentElementCopilot(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        int[] hash = new int[100001];

        for(int num : nums) {
            hash[num]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                index = i;
            }
        }
        return index;
    }

    public int mostFrequentElement(int[] nums) {

        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        int[] hash = new int[sortedArray[sortedArray.length - 1] + 1];
        for (int num : nums) {
            hash[num]++;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                index = i;
            }
        }
        return index;
    }

    public int mostFrequentElementStriverBruteForce(int[] nums) {

        // Variable to store the size of array
        int n = nums.length;

        // Variable to store maximum frequency
        int maxFreq = 0;

        /* Variable to store element
        with maximum frequency */
        int maxEle = 0;

        // Visited array
        boolean[] visited = new boolean[n];

        // First loop
        for (int i = 0; i < n; i++) {
            // Skip second loop if already visited
            if (visited[i]) continue;

            /* Variable to store frequency
            of current element */
            int freq = 0;

            // Second loop
            for (int j = i; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                    visited[j] = true;
                }
            }

            /* Update variables if new element having
            highest frequency is found */
            if (freq > maxFreq) {
                maxFreq = freq;
                maxEle = nums[i];
            } else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, nums[i]);
            }
        }

        // Return the result
        return maxEle;
    }

    public int mostFrequentElementStriverOptimal(int[] nums) {

        // Variable to store the size of array
        int n = nums.length;

        // Variable to store maximum frequency
        int maxFreq = 0;

        /* Variable to store element
        with maximum frequency */
        int maxEle = 0;

        // HashMap
        Map<Integer, Integer> mpp = new HashMap<>();

        // Iterating on the array
        for (int i = 0; i < n; i++) {
            // Updating hashmap
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        // Iterate on the map
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            int ele = it.getKey(); // Key
            int freq = it.getValue(); // Value

            if (freq > maxFreq) {
                maxFreq = freq;
                maxEle = ele;
            } else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
        }

        // Return the result
        return maxEle;
    }
}
