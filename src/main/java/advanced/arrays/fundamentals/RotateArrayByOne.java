package advanced.arrays.fundamentals;

public class RotateArrayByOne {

    public static void main(String[] args) {
        RotateArrayByOne r = new RotateArrayByOne();
        int[] nums = {1, 2, 3, 4, 5};
        r.rotateArrayByOne(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void rotateArrayByOne(int[] nums) {
        int length = nums.length;
        int temp = nums[0];
        for (int i = 1; i <= length - 1; i++) {
            nums[i - 1] = nums[i];
        }
        nums[length - 1] = temp;
    }
}
