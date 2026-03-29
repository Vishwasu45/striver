package advanced.arrays.faqmedium;

public class MajorityElement1 {

    public static void main(String[] args) {
        MajorityElement1 solution = new MajorityElement1();
        int[] nums = {2, 2, 1, 1, 1, 2, 2}; // Example input
        System.out.println("Majority element is: " + solution.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (i == num) {
                    count++;
                }
            }
            if (count > (nums.length / 2)) {
                return num;
            }
        }
        return -1;
    }
}
