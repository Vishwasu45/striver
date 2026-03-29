package advanced.arrays.logicbuilding;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public static void main(String[] args) {
        IntersectionOfTwoSortedArrays solution = new IntersectionOfTwoSortedArrays();
        int[] nums1 = {1, 2, 2, 3, 5}; // Example input
        int[] nums2 = {1, 2, 7};    // Example input
        int[] intersection = solution.intersectionArray(nums1, nums2);
        System.out.print("Intersection of the two sorted arrays: ");
        for (int num : intersection) {
            if (num != 0) { // To avoid printing uninitialized elements
                System.out.print(num + " ");
            }
        }
    }

    public int[] intersectionArrayStriverBruteForce(int[] nums1, int[] nums2) {
        List<Integer> ansList = new ArrayList<>();
        int[] visited = new int[nums2.length];

        for (int value : nums1) {
            for (int j = 0; j < nums2.length; j++) {

                /*If nums1[i] is equal to nums2[j] and nums2[j]
                is not visited then add nums2[j] in ans.*/
                if (value == nums2[j] && visited[j] == 0) {

                    ansList.add(nums2[j]);
                    // Mark as visited
                    visited[j] = 1;

                    break;
                }
                //If nums2[j] is greater than nums1[i], break out of loop
                else if (nums2[j] > value)
                    break;
            }
        }

        //Return the final ans
        return ansList.stream().mapToInt(x -> x).toArray();
    }

    public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                // Found a match
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }
        return intersection.stream().mapToInt(x -> x).toArray();
    }
}
