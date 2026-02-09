package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CollectionComparison {

    public static void main(String[] args) {
        // Input data with duplicates and specific order
        String[] data = {"Apple", "Banana", "Apple", "Cherry"};

        // 1. List: Preserves order and allows duplicates
        List<String> list = new ArrayList<>(Arrays.asList(data));

        // 2. Set: Removes duplicates and doesn't guarantee order
        Set<String> set = new HashSet<>(Arrays.asList(data));

        // 3. Queue: Focuses on processing order (FIFO)
        Queue<String> queue = new LinkedList<>(Arrays.asList(data));

        System.out.println("List (Ordered): " + list);
        // Output: [Apple, Banana, Apple, Cherry]

        System.out.println("Set (Unique):   " + set);
        // Output: [Apple, Cherry, Banana] (Order may vary)

        System.out.println("Queue (Head):   " + queue.peek());
        // Output: Apple (The first one in is the first one out)
    }
}
