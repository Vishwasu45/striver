package basicHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HighestOccuringElementInAnArray {

    public static void main(String[] args) {
        HighestOccuringElementInAnArray obj = new HighestOccuringElementInAnArray();
        int[] nums = {1, 3, 2, 3, 4, 1, 3};
        System.out.println(obj.mostFrequentElement(nums));
        System.out.println(obj.mostFrequentElementStriver(nums));
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

    public int mostFrequentElementStriver(int[] nums) {

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
