package advanced.arrays.logicbuilding;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        MoveZerosToEnd m = new MoveZerosToEnd();
        int[] nums = {0, 1, 0, 3, 12};
        m.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        int temp[] = new int[nums.length];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
                temp[count++] = nums[i];
            }
        }
        for(int i = 0; i < count; i++) {
            nums[i] = temp[i];
        }
        for(int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
