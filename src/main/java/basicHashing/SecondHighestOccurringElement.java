package basicHashing;

import java.util.HashMap;
import java.util.Map;

public class SecondHighestOccurringElement {

    public static void main(String[] args) {
        SecondHighestOccurringElement obj = new SecondHighestOccurringElement();
        int[] nums = {1, 3, 2, 3, 4, 1, 3};
        System.out.println(obj.secondMostFrequentElementStriverBruteForce(nums));
        System.out.println(obj.secondMostFrequentElementCopilot(nums));

    }

    public int secondMostFrequentElementCopilot(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int index = -1;
        int secIndex = -1;

        int[] hash = new int[100001];

        for(int num : nums) {
            hash[num]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                secMax = max;
                secIndex = index;
                max = hash[i];
                index = i;
            } else if (hash[i] > secMax && hash[i] != max) {
                secMax = hash[i];
                secIndex = i;
            }
        }
        return secIndex;
    }

    public int secondMostFrequentElementStriverBruteForce(int[] nums) {

        // Variable to store the size of array
        int n = nums.length;

        /* Variable to store maximum frequency
        and second maximum frequency */
        int maxFreq = 0, secMaxFreq = 0;

        /* Variable to store element
        with maximum frequency and second
        highest frequency */
        int maxEle = -1, secEle = -1;

        // HashMap
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Iterating on the array
        for (int i = 0; i < n; i++) {
            // Updating hashmap
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        // Iterate on the map
        for(Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            int ele = it.getKey(); // Key
            int freq = it.getValue(); // Value

            /* Update variables if new element
            having highest frequency or second
            highest frequency is found */
            if(freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = ele;
            }
            else if(freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
            else if(freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = ele;
            }
            else if(freq == secMaxFreq) {
                secEle = Math.min(secEle, ele);
            }
        }

        // Return the result
        return secEle;
    }

    public int secondMostFrequentElementStriverOptimal(int[] nums) {

        // Variable to store the size of array
        int n = nums.length;

        /* Variable to store maximum frequency
        and second maximum frequency */
        int maxFreq = 0, secMaxFreq = 0;

        /* Variable to store element
        with maximum frequency and second
        highest frequency */
        int maxEle = -1, secEle = -1;

        // HashMap
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Iterating on the array
        for (int i = 0; i < n; i++) {
            // Updating hashmap
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        // Iterate on the map
        for(Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            int ele = it.getKey(); // Key
            int freq = it.getValue(); // Value

            /* Update variables if new element
            having highest frequency or second
            highest frequency is found */
            if(freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = ele;
            }
            else if(freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
            else if(freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = ele;
            }
            else if(freq == secMaxFreq) {
                secEle = Math.min(secEle, ele);
            }
        }

        // Return the result
        return secEle;
    }
}
