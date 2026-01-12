package advanced.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] nums = { 7, 4, 1, 5, 3 };
        var sortedArray = ss.selectionSort(nums);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }

    public int[] selectionSort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

}
