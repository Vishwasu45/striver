package basicArrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        int[] arr = {1, 2, 3, 4, 5}; // Example array
        int n = arr.length;
        reverseAnArray.reverse(arr, n);

        // Print the reversed array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void reverseTwoPointer(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public void reverse(int[] arr, int n) {
        for(int i = 0; i < n/2;i++) {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
}
