package other;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 23;
        int[] result = coinChange(coins, amount);
        System.out.println("Coins used to make " + amount + ": " + Arrays.toString(result));
    }

    public static int[] coinChange(int[] coins, int amount) {
        // Use ArrayList for dynamic sizing instead of fixed array
        List<Integer> resultList = new ArrayList<>();
        
        // Sort coins in descending order for greedy approach
        Arrays.sort(coins);
        
        // Start from largest coin and work backwards
        for (int i = coins.length - 1; i >= 0 && amount > 0; i--) {
            // Use as many of current coin as possible
            while (amount >= coins[i]) {
                resultList.add(coins[i]);
                amount -= coins[i];
            }
        }
        
        // Convert ArrayList to array with exact size needed
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
