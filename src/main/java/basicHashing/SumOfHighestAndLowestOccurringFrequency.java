package basicHashing;

import java.util.Arrays;
import java.util.HashMap;

public class SumOfHighestAndLowestOccurringFrequency {

    public static void main(String[] args) {
        SumOfHighestAndLowestOccurringFrequency obj = new SumOfHighestAndLowestOccurringFrequency();
        int[] nums = {4, 4, 5, 5, 6};
        System.out.println(obj.sumHighestAndLowestFrequency(nums));
        System.out.println(obj.sumHighestAndLowestFrequencyCopilot(nums));
        System.out.println(obj.sumHighestAndLowestFrequencyStriverBruteForce(nums));
    }

    public int sumHighestAndLowestFrequency(int[] nums) {
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        int[] hash = new int[sortedArray[sortedArray.length - 1] + 1];

        for(int num : nums) {
            hash[num]++;
        }

        int max = Integer.MIN_VALUE;
        int indexHigh = -1;

        for(int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                indexHigh = i;
            }
        }

        int low = Integer.MAX_VALUE;
        int indexLow = -1;

        for(int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) {
                continue;
            }
            if (hash[i] < low) {
                low = hash[i];
                indexLow = i;
            }
        }

        return hash[indexHigh] + hash[indexLow];

    }

    public int sumHighestAndLowestFrequencyCopilot(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] hash = new int[100001];

        for(int num : nums) {
            hash[num]++;
        }

        for (int j : hash) {
            if (j > max) {
                max = j;
            }
            if (j != 0 && j < min) {
                min = j;
            }
        }

        return max + min;
    }

    public int sumHighestAndLowestFrequencyStriverBruteForce(int[] nums) {
        // Variable to store the size of array
        int n = nums.length;

        /* Variable to store maximum
        and minimum frequency */
        int maxFreq = 0;
        int minFreq = n;

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

            /* Update maximum and
            minimum frequencies */
            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);

        }

        // Return the required sum
        return maxFreq + minFreq;
    }

    public int sumHighestAndLowestFrequencyStriverOptimal(int[] nums) {
        // Variable to store the size of array
        int n = nums.length;

        /* Variable to store maximum
        and minimum frequency */
        int maxFreq = 0, minFreq = n;

        // HashMap
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Iterating on the array
        for (int i = 0; i < n; i++) {
            // Updating hashmap
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        // Iterate on the map
        for (int freq : mpp.values()) {
            /* Update maximum and
            minimum frequencies */
            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);
        }

        // Return the required sum
        return maxFreq + minFreq;
    }
    
}
