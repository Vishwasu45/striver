package advanced.arrays.logicbuilding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {
        UnionOfTwoSortedArrays solution = new UnionOfTwoSortedArrays();
        int[] nums1 = {1, 2, 4, 5, 6}; // Example input
        int[] nums2 = {2, 3, 5, 7};    // Example input
        
        int[] union = solution.unionArray(nums1, nums2);
        System.out.print("Union (using Set): ");
        for (int num : union) {
            if (num != 0) {
                System.out.print(num + " ");
            }
        }
        
        System.out.println();
        
        int[] unionTwoPointer = solution.unionArrayTwoPointer(nums1, nums2);
        System.out.print("Union (using Two Pointer): ");
        for (int num : unionTwoPointer) {
            System.out.print(num + " ");
        }
    }

    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int k : nums1) {
            set.add(k);
        }
        for (int k : nums2) {
            set.add(k);
        }
        int[] unionArray = new int[set.size()];
        int i = 0;
        for (int num : set) {
            unionArray[i++] = num;
        }
        return unionArray;
    }

    public int[] unionArrayTwoPointer(int[] nums1, int[] nums2) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                // Add nums1[i] if not duplicate
                if (union.isEmpty() || union.get(union.size() - 1) != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                // Add nums2[j] if not duplicate
                if (union.isEmpty() || union.get(union.size() - 1) != nums2[j]) {
                    union.add(nums2[j]);
                }
                j++;
            } else {
                // Both are equal, add one and skip duplicates
                if (union.isEmpty() || union.get(union.size() - 1) != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        // Add remaining elements from nums1
        while (i < nums1.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != nums1[i]) {
                union.add(nums1[i]);
            }
            i++;
        }

        // Add remaining elements from nums2
        while (j < nums2.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != nums2[j]) {
                union.add(nums2[j]);
            }
            j++;
        }

        return union.stream().mapToInt(x -> x).toArray();
    }
}
