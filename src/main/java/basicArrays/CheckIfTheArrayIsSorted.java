package basicArrays;

public class CheckIfTheArrayIsSorted {

    public static void main(String[] args) {
        CheckIfTheArrayIsSorted checkIfTheArrayIsSorted = new CheckIfTheArrayIsSorted();
        int[] arr = {1, 2, 3, 4, 5}; // Example array
        int n = arr.length;
        boolean result = checkIfTheArrayIsSorted.arraySortedOrNot(arr, n);
        System.out.println("Is the array sorted? " + result);
    }

    boolean arraySortedOrNot(int[] arr, int n) {
        for(int i = 0;i<n-1;i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
