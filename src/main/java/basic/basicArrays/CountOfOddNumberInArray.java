package basic.basicArrays;

public class CountOfOddNumberInArray {

    public static void main(String[] args) {
        CountOfOddNumberInArray countOfOddNumberInArray = new CountOfOddNumberInArray();
        int[] arr = { 1, 2, 3, 4, 5 }; // Example array
        int n = arr.length;
        int result = countOfOddNumberInArray.countOdd(arr, n);
        System.out.println("Count of odd numbers in the array: " + result);

    }

    public int countOdd(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }
}
