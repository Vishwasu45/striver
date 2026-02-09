package other;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Demonstrates all Set implementations in Java Collections Framework
 */
public class SetExamples {
    public static void main(String[] args) {
        hashSetExample();
        linkedHashSetExample();
        treeSetExample();
        enumSetExample();
        copyOnWriteArraySetExample();
        concurrentSkipListSetExample();
    }

    // HashSet - Hash table based set, no ordering
    private static void hashSetExample() {
        System.out.println("=== HashSet Example ===");
        Set<String> hashSet = new HashSet<>();

        // Adding elements
        hashSet.add("Dog");
        hashSet.add("Cat");
        hashSet.add("Bird");
        hashSet.add("Dog"); // Duplicate - will not be added

        // No ordering guaranteed
        System.out.println("HashSet: " + hashSet);

        // Contains check
        System.out.println("Contains Cat: " + hashSet.contains("Cat"));

        // Remove
        hashSet.remove("Bird");

        // Size
        System.out.println("Size: " + hashSet.size());

        // Iteration
        System.out.println("Iterating:");
        for (String animal : hashSet) {
            System.out.println("  " + animal);
        }

        System.out.println();
    }

    // LinkedHashSet - Hash table with linked list, maintains insertion order
    private static void linkedHashSetExample() {
        System.out.println("=== LinkedHashSet Example ===");
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        // Adding elements
        linkedHashSet.add(50);
        linkedHashSet.add(10);
        linkedHashSet.add(30);
        linkedHashSet.add(20);
        linkedHashSet.add(10); // Duplicate

        // Maintains insertion order
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        // Operations
        linkedHashSet.remove(30);
        System.out.println("After removing 30: " + linkedHashSet);

        System.out.println();
    }

    // TreeSet - NavigableSet implementation based on TreeMap, sorted order
    private static void treeSetExample() {
        System.out.println("=== TreeSet Example ===");
        TreeSet<String> treeSet = new TreeSet<>();

        // Adding elements
        treeSet.add("Zebra");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Banana");

        // Natural ordering (sorted)
        System.out.println("TreeSet (sorted): " + treeSet);

        // NavigableSet operations
        System.out.println("First: " + treeSet.first());
        System.out.println("Last: " + treeSet.last());
        System.out.println("Higher than Banana: " + treeSet.higher("Banana"));
        System.out.println("Lower than Mango: " + treeSet.lower("Mango"));

        // Subset operations
        System.out.println("HeadSet (< Mango): " + treeSet.headSet("Mango"));
        System.out.println("TailSet (>= Banana): " + treeSet.tailSet("Banana"));
        System.out.println("SubSet (Banana to Zebra): " + treeSet.subSet("Banana", "Zebra"));

        // Descending order
        System.out.println("Descending: " + treeSet.descendingSet());

        // Poll operations
        System.out.println("Poll first: " + treeSet.pollFirst());
        System.out.println("Poll last: " + treeSet.pollLast());
        System.out.println("After polling: " + treeSet);

        System.out.println();
    }

    // EnumSet - Specialized Set for enum types
    private static void enumSetExample() {
        System.out.println("=== EnumSet Example ===");

        // Create EnumSet with all values
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All days: " + allDays);

        // Create empty EnumSet
        EnumSet<Day> noDays = EnumSet.noneOf(Day.class);
        System.out.println("No days: " + noDays);

        // Create EnumSet with specific values
        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);

        // Create EnumSet with range
        EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Weekdays: " + weekdays);

        // Complement
        EnumSet<Day> notWeekend = EnumSet.complementOf(weekend);
        System.out.println("Not weekend: " + notWeekend);

        System.out.println();
    }

    // CopyOnWriteArraySet - Thread-safe Set backed by CopyOnWriteArrayList
    private static void copyOnWriteArraySetExample() {
        System.out.println("=== CopyOnWriteArraySet Example ===");
        CopyOnWriteArraySet<String> cowSet = new CopyOnWriteArraySet<>();

        cowSet.add("Thread");
        cowSet.add("Safe");
        cowSet.add("Set");

        System.out.println("CopyOnWriteArraySet: " + cowSet);

        // Safe iteration during modification
        for (String s : cowSet) {
            System.out.println("  " + s);
        }

        System.out.println();
    }

    // ConcurrentSkipListSet - Concurrent sorted set
    private static void concurrentSkipListSetExample() {
        System.out.println("=== ConcurrentSkipListSet Example ===");
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();

        skipListSet.add(50);
        skipListSet.add(10);
        skipListSet.add(30);
        skipListSet.add(20);

        System.out.println("ConcurrentSkipListSet (sorted): " + skipListSet);
        System.out.println("First: " + skipListSet.first());
        System.out.println("Last: " + skipListSet.last());

        System.out.println();
    }

    // Enum for EnumSet example
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}

