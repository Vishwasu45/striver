package advanced.arrays.fundamentals;

import java.util.Arrays;

public class SecondLargestElement {

    public static void main(String[] args) {
        SecondLargestElement s = new SecondLargestElement();
        int[] nums = {3,2,1,5,2};
        var secondLargestElement = s.secondLargestElement(nums);
        System.out.println(secondLargestElement);
    }

    public int secondLargestElement(int[] nums) {
        Arrays.sort(nums);
        int largest = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != largest) {
                return nums[i];
            }
        }
        return -1;
    }
}
