package advanced.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        InsertionSort insertionSort = new InsertionSort();
        var sortedArray = insertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(sortedArray));
    }

    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j]; // shift
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }
}
