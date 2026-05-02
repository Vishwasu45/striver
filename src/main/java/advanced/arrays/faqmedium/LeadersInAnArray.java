package advanced.arrays.faqmedium;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {

    public static void main(String[] args) {
        LeadersInAnArray leadersInAnArray = new LeadersInAnArray();
        int[] nums = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = leadersInAnArray.leaders(nums);
        System.out.println(leaders);
    }

    public List<Integer> leaders(int[] nums) {
        List<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < nums.length;i++) {
            boolean leader = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader) {
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }
}
