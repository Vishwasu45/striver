package advanced.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = { 7, 4, 1, 5, 3 };
        var sortedArray = bubbleSort.bubbleSort(nums);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }

    public int[] bubbleSortBestCase(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int size = nums.length;
        for (int i = size - 1; i >= 1; i--) {
            boolean didSwap = false;
            for (int j = 0; j <= i - 1 ; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }
        return nums;
    }

    public int[] bubbleSort(int[] nums) {
        int size = nums.length;
        for (int i = size - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1 ; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
