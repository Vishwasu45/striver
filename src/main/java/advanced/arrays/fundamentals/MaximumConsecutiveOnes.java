package advanced.arrays.fundamentals;

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        MaximumConsecutiveOnes m = new MaximumConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1};
        var maxConsecutiveOnes = m.findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int count = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (1 == nums[i]) {
                count = count + 1;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
