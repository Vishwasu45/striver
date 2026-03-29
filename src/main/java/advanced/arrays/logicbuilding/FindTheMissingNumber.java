package advanced.arrays.logicbuilding;

public class FindTheMissingNumber {

    public static void main(String[] args) {
        FindTheMissingNumber solution = new FindTheMissingNumber();
        int[] nums = {0, 1, 3}; // Example input
        int missing = solution.missingNumber(nums);
        System.out.println("The missing number is: " + missing);
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            int flag = 0;
            for (int num : nums) {
                if (num == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }
}
