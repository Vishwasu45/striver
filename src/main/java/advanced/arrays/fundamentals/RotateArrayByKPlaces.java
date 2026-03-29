package advanced.arrays.fundamentals;

public class RotateArrayByKPlaces {

    public static void main(String[] args) {
        RotateArrayByKPlaces r = new RotateArrayByKPlaces();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        r.rotateArray(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void rotateArray(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] temp = new int[k];
        for(int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }

        for (int i = k; i < length; i++) {
            nums[i - k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[length - k + i] = temp[i];
        }
    }
}
