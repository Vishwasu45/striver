package other;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Demonstrates all Map implementations in Java Collections Framework
 */
public class MapExamples {
    public static void main(String[] args) {
        hashMapExample();
        linkedHashMapExample();
        treeMapExample();
        hashtableExample();
        identityHashMapExample();
        weakHashMapExample();
        enumMapExample();
        concurrentHashMapExample();
        concurrentSkipListMapExample();
    }

    // HashMap - Hash table based map, no ordering
    private static void hashMapExample() {
        System.out.println("=== HashMap Example ===");
        Map<String, Integer> hashMap = new HashMap<>();

        // Put key-value pairs
        hashMap.put("Apple", 10);
        hashMap.put("Banana", 20);
        hashMap.put("Cherry", 30);
        hashMap.put("Apple", 15); // Overwrites previous value

        // Get value
        System.out.println("Value for Apple: " + hashMap.get("Apple"));

        // Check if key/value exists
        System.out.println("Contains key Banana: " + hashMap.containsKey("Banana"));
        System.out.println("Contains value 30: " + hashMap.containsValue(30));

        // Remove
        hashMap.remove("Cherry");

        // Size
        System.out.println("Size: " + hashMap.size());

        // Iterate through keys
        System.out.println("Keys:");
        for (String key : hashMap.keySet()) {
            System.out.println("  " + key);
        }

        // Iterate through values
        System.out.println("Values:");
        for (Integer value : hashMap.values()) {
            System.out.println("  " + value);
        }

        // Iterate through entries
        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }

        // getOrDefault
        System.out.println("Orange (default 0): " + hashMap.getOrDefault("Orange", 0));

        // putIfAbsent
        hashMap.putIfAbsent("Date", 40);
        hashMap.putIfAbsent("Apple", 100); // Won't overwrite

        System.out.println("HashMap: " + hashMap);
        System.out.println();
    }

    // LinkedHashMap - Hash table with linked list, maintains insertion order
    private static void linkedHashMapExample() {
        System.out.println("=== LinkedHashMap Example ===");
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(3, "Three");
        linkedHashMap.put(1, "One");
        linkedHashMap.put(4, "Four");
        linkedHashMap.put(2, "Two");

        // Maintains insertion order
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);

        // Access-order LinkedHashMap
        LinkedHashMap<Integer, String> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put(1, "One");
        accessOrderMap.put(2, "Two");
        accessOrderMap.put(3, "Three");

        accessOrderMap.get(1); // Access key 1
        System.out.println("After accessing 1: " + accessOrderMap);

        System.out.println();
    }

    // TreeMap - NavigableMap based on Red-Black tree, sorted by keys
    private static void treeMapExample() {
        System.out.println("=== TreeMap Example ===");
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("Zebra", 26);
        treeMap.put("Apple", 1);
        treeMap.put("Mango", 13);
        treeMap.put("Banana", 2);

        // Natural ordering (sorted by keys)
        System.out.println("TreeMap (sorted): " + treeMap);

        // NavigableMap operations
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println("Higher key than Banana: " + treeMap.higherKey("Banana"));
        System.out.println("Lower key than Mango: " + treeMap.lowerKey("Mango"));

        // First and last entry
        System.out.println("First entry: " + treeMap.firstEntry());
        System.out.println("Last entry: " + treeMap.lastEntry());

        // Submap operations
        System.out.println("HeadMap (< Mango): " + treeMap.headMap("Mango"));
        System.out.println("TailMap (>= Banana): " + treeMap.tailMap("Banana"));
        System.out.println("SubMap (Banana to Zebra): " + treeMap.subMap("Banana", "Zebra"));

        // Descending map
        System.out.println("Descending: " + treeMap.descendingMap());

        System.out.println();
    }

    // Hashtable - Synchronized hash table, legacy class
    private static void hashtableExample() {
        System.out.println("=== Hashtable Example ===");
        Hashtable<String, String> hashtable = new Hashtable<>();

        hashtable.put("USA", "Washington D.C.");
        hashtable.put("India", "New Delhi");
        hashtable.put("Japan", "Tokyo");

        System.out.println("Hashtable: " + hashtable);

        // Does not allow null key or value
        // hashtable.put(null, "Value"); // Throws NullPointerException
        // hashtable.put("Key", null); // Throws NullPointerException

        System.out.println();
    }

    // IdentityHashMap - Uses reference equality instead of object equality
    private static void identityHashMapExample() {
        System.out.println("=== IdentityHashMap Example ===");
        IdentityHashMap<String, Integer> identityMap = new IdentityHashMap<>();

        String s1 = new String("Key");
        String s2 = new String("Key");
        String s3 = "Key";

        identityMap.put(s1, 1);
        identityMap.put(s2, 2);
        identityMap.put(s3, 3);

        // Different references, so all three are stored
        System.out.println("Size: " + identityMap.size());
        System.out.println("IdentityHashMap: " + identityMap);

        // Compare with regular HashMap
        HashMap<String, Integer> regularMap = new HashMap<>();
        regularMap.put(s1, 1);
        regularMap.put(s2, 2);
        regularMap.put(s3, 3);
        System.out.println("Regular HashMap size: " + regularMap.size()); // Only 1 entry

        System.out.println();
    }

    // WeakHashMap - Uses weak references for keys
    private static void weakHashMapExample() {
        System.out.println("=== WeakHashMap Example ===");
        WeakHashMap<String, Integer> weakMap = new WeakHashMap<>();

        String key1 = new String("Key1");
        String key2 = new String("Key2");

        weakMap.put(key1, 100);
        weakMap.put(key2, 200);

        System.out.println("Before GC: " + weakMap);
        System.out.println("Size: " + weakMap.size());

        // Remove strong reference
        key1 = null;

        // Suggest garbage collection
        System.gc();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After GC: " + weakMap);
        System.out.println("Size: " + weakMap.size());

        System.out.println();
    }

    // EnumMap - Specialized Map for enum keys
    private static void enumMapExample() {
        System.out.println("=== EnumMap Example ===");
        EnumMap<Size, String> enumMap = new EnumMap<>(Size.class);

        enumMap.put(Size.SMALL, "S");
        enumMap.put(Size.MEDIUM, "M");
        enumMap.put(Size.LARGE, "L");
        enumMap.put(Size.EXTRA_LARGE, "XL");

        System.out.println("EnumMap: " + enumMap);

        // Very efficient for enum keys
        System.out.println("Medium: " + enumMap.get(Size.MEDIUM));

        System.out.println();
    }

    // ConcurrentHashMap - Thread-safe HashMap without locking entire map
    private static void concurrentHashMapExample() {
        System.out.println("=== ConcurrentHashMap Example ===");
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        concurrentMap.put("C", 3);

        System.out.println("ConcurrentHashMap: " + concurrentMap);

        // putIfAbsent (atomic operation)
        concurrentMap.putIfAbsent("D", 4);

        // compute operations
        concurrentMap.compute("A", (key, value) -> value * 10);
        System.out.println("After compute: " + concurrentMap);

        // computeIfPresent
        concurrentMap.computeIfPresent("B", (key, value) -> value + 10);

        // computeIfAbsent
        concurrentMap.computeIfAbsent("E", key -> 5);

        System.out.println("Final map: " + concurrentMap);

        System.out.println();
    }

    // ConcurrentSkipListMap - Concurrent sorted map
    private static void concurrentSkipListMapExample() {
        System.out.println("=== ConcurrentSkipListMap Example ===");
        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();

        skipListMap.put(30, "Thirty");
        skipListMap.put(10, "Ten");
        skipListMap.put(40, "Forty");
        skipListMap.put(20, "Twenty");

        System.out.println("ConcurrentSkipListMap (sorted): " + skipListMap);
        System.out.println("First key: " + skipListMap.firstKey());
        System.out.println("Last key: " + skipListMap.lastKey());

        System.out.println();
    }

    // Enum for EnumMap example
    enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }
}

