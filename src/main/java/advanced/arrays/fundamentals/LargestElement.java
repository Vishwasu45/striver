package advanced.arrays.fundamentals;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        LargestElement l = new LargestElement();
        int[] nums = {3,2,1,5,2};
        var largestElement = l.largestElement(nums);
        System.out.println(largestElement);
    }

    public int largestElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
}
