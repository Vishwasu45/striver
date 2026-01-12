package basic.basicArrays;

public class SumOfArrayElements {

    public static void main(String[] args) {
        SumOfArrayElements sumOfArrayElements = new SumOfArrayElements();
        int[] arr = { 1, 2, 3, 4, 5 }; // Example array
        int n = arr.length;
        int result = sumOfArrayElements.sum(arr, n);
        System.out.println("Sum of array elements: " + result);
    }

    public int sum(int arr[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = count + arr[i];
        }
        return count;
    }
}
