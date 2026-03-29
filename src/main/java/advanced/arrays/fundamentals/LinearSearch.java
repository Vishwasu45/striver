package advanced.arrays.fundamentals;

public class LinearSearch {

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 9;
        var place = linearSearch.linearSearch(arr, target);
        System.out.println(place);
    }

    public int linearSearch(int[] nums, int target) {
        //Your code goes here
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
