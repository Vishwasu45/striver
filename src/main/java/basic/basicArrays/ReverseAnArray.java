package basic.basicArrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        int[] arr = { 1, 2, 3, 4, 5 }; // Example array
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
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    public void reverseStriverOptimal(int[] arr, int n) {
        int p1 = 0, p2 = n - 1;
        /*
         * Swap elements pointed by p1 and
         * p2 until they meet in the middle
         */
        while (p1 < p2) {
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
            p1++;
            p2--;
        }
    }

    public void reverseStriverBruteForce(int arr[], int n) {
        int[] ans = new int[n];

        /*
         * Fill new array with elements of
         * original array in reverse order
         */
        for (int i = n - 1; i >= 0; i--) {
            ans[n - i - 1] = arr[i];
        }

        // Copy the elements back to the original array
        for (int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }
}
