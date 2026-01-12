package basic.basicRecursion;

import java.util.Arrays;

public class SumOfArrayElements {

    public static void main(String[] args) {
        SumOfArrayElements solution = new SumOfArrayElements();
        int[] nums = { 1, 2, 3, 4, 5 }; // Example input
        System.out.println("Sum of array elements: " + solution.arraySum(nums));
        System.out.println("Sum of array elements (Striver): " + solution.arraySumStriver(nums));
    }

    public int arraySumStriver(int[] nums) {
        // Start from index 0
        return sum(nums, 0);
    }

    private int sum(int[] nums, int left) {
        // Base case: out of bounds
        if (left >= nums.length) {
            return 0;
        }
        // Add current element and recurse
        return nums[left] + sum(nums, left + 1);
    }

    public int arraySum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] next = Arrays.copyOfRange(nums, 1, nums.length);
        return nums[0] + arraySum(next);
    }
}
