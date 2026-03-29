package advanced.arrays.logicbuilding;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2, 2, 2, 3, 3}; // Example input
        int newLength = solution.removeDuplicates(nums);
        System.out.println("New length after removing duplicates: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int index = 0;
        for (int i : set) {
            nums[index] = i;
            index++;
        }
        return index;
    }
}
