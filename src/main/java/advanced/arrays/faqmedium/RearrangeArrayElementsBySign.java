package advanced.arrays.faqmedium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        RearrangeArrayElementsBySign rearrangeArrayElementsBySign = new RearrangeArrayElementsBySign();
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] rearranged = rearrangeArrayElementsBySign.rearrangeArray(nums);
        for (int i : rearranged) {
            System.out.print(i + " ");
        }
    }

    public int[] rearrangeArray(int[] nums) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int num : nums) {
            if (num < 0) {
                negatives.add(num);
            } else {
                positives.add(num);
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = positives.get(i);
            nums[2 * i + 1] = negatives.get(i);
        }
        return nums;
    }
}
