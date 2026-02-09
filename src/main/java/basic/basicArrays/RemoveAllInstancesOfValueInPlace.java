package basic.basicArrays;

public class RemoveAllInstancesOfValueInPlace {

    public static void main(String[] args) {
        RemoveAllInstancesOfValueInPlace remover = new RemoveAllInstancesOfValueInPlace();
        int[] nums = {3, 2, 2, 3, 4, 5, 3};
        int val = 3;
        int newLength = remover.removeElement(nums, val);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
