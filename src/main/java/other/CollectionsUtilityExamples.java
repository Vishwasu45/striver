package other;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Demonstrates Collections utility class methods and algorithms
 */
public class CollectionsUtilityExamples {
    public static void main(String[] args) {
        sortingExamples();
        searchingExamples();
        shuffleAndReverseExamples();
        fillAndReplaceExamples();
        frequencyAndDisjointExamples();
        minMaxExamples();
        rotateAndSwapExamples();
        unmodifiableCollectionsExamples();
        synchronizedCollectionsExamples();
        checkedCollectionsExamples();
        emptyAndSingletonExamples();
        binarySearchExample();
    }

    // Sorting examples
    private static void sortingExamples() {
        System.out.println("=== Sorting Examples ===");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("Original: " + numbers);

        // Sort in natural order
        Collections.sort(numbers);
        System.out.println("Sorted ascending: " + numbers);

        // Sort in reverse order
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted descending: " + numbers);

        // Sort with custom comparator
        List<String> words = new ArrayList<>(Arrays.asList("apple", "pie", "a", "banana"));
        Collections.sort(words, Comparator.comparingInt(String::length));
        System.out.println("Sorted by length: " + words);

        System.out.println();
    }

    // Searching examples
    private static void searchingExamples() {
        System.out.println("=== Searching Examples ===");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 9));

        // Binary search (list must be sorted)
        int index = Collections.binarySearch(numbers, 5);
        System.out.println("Index of 5: " + index);

        int notFound = Collections.binarySearch(numbers, 4);
        System.out.println("Index of 4 (not found): " + notFound);

        System.out.println();
    }

    // Shuffle and reverse examples
    private static void shuffleAndReverseExamples() {
        System.out.println("=== Shuffle and Reverse Examples ===");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original: " + numbers);

        // Shuffle
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);

        // Reverse
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        System.out.println();
    }

    // Fill and replace examples
    private static void fillAndReplaceExamples() {
        System.out.println("=== Fill and Replace Examples ===");

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        System.out.println("Original: " + list);

        // Fill with same element
        Collections.fill(list, "X");
        System.out.println("After fill: " + list);

        // Replace all occurrences
        list = new ArrayList<>(Arrays.asList("a", "b", "a", "c", "a"));
        Collections.replaceAll(list, "a", "Z");
        System.out.println("After replace: " + list);

        System.out.println();
    }

    // Frequency and disjoint examples
    private static void frequencyAndDisjointExamples() {
        System.out.println("=== Frequency and Disjoint Examples ===");

        List<String> list = Arrays.asList("a", "b", "a", "c", "a", "b");

        // Frequency
        int frequency = Collections.frequency(list, "a");
        System.out.println("Frequency of 'a': " + frequency);

        // Disjoint (no common elements)
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("d", "e", "f");
        List<String> list3 = Arrays.asList("c", "d", "e");

        System.out.println("list1 and list2 disjoint: " + Collections.disjoint(list1, list2));
        System.out.println("list1 and list3 disjoint: " + Collections.disjoint(list1, list3));

        System.out.println();
    }

    // Min and max examples
    private static void minMaxExamples() {
        System.out.println("=== Min and Max Examples ===");

        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);

        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));

        // With custom comparator
        List<String> words = Arrays.asList("apple", "pie", "a", "banana");
        System.out.println("Shortest word: " + Collections.min(words, Comparator.comparingInt(String::length)));
        System.out.println("Longest word: " + Collections.max(words, Comparator.comparingInt(String::length)));

        System.out.println();
    }

    // Rotate and swap examples
    private static void rotateAndSwapExamples() {
        System.out.println("=== Rotate and Swap Examples ===");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original: " + numbers);

        // Rotate right by 2
        Collections.rotate(numbers, 2);
        System.out.println("Rotated right by 2: " + numbers);

        // Rotate left by 2
        Collections.rotate(numbers, -2);
        System.out.println("Rotated left by 2: " + numbers);

        // Swap elements
        Collections.swap(numbers, 0, 4);
        System.out.println("After swap(0, 4): " + numbers);

        System.out.println();
    }

    // Unmodifiable collections examples
    private static void unmodifiableCollectionsExamples() {
        System.out.println("=== Unmodifiable Collections Examples ===");

        List<String> mutableList = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<String> unmodifiableList = Collections.unmodifiableList(mutableList);

        System.out.println("Unmodifiable list: " + unmodifiableList);

        try {
            unmodifiableList.add("d");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify unmodifiable list");
        }

        // Unmodifiable Set
        Set<Integer> unmodifiableSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3)));
        System.out.println("Unmodifiable set: " + unmodifiableSet);

        // Unmodifiable Map
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        System.out.println("Unmodifiable map: " + unmodifiableMap);

        System.out.println();
    }

    // Synchronized collections examples
    private static void synchronizedCollectionsExamples() {
        System.out.println("=== Synchronized Collections Examples ===");

        // Synchronized List
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add("Thread-safe");
        syncList.add("List");
        System.out.println("Synchronized list: " + syncList);

        // Synchronized Set
        Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
        syncSet.add(1);
        syncSet.add(2);
        System.out.println("Synchronized set: " + syncSet);

        // Synchronized Map
        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        syncMap.put("key", "value");
        System.out.println("Synchronized map: " + syncMap);

        // Note: Must synchronize on the collection when iterating
        synchronized (syncList) {
            for (String s : syncList) {
                System.out.println("  " + s);
            }
        }

        System.out.println();
    }

    // Checked collections examples
    private static void checkedCollectionsExamples() {
        System.out.println("=== Checked Collections Examples ===");

        // Checked List - runtime type checking
        List<String> checkedList = Collections.checkedList(new ArrayList<>(), String.class);
        checkedList.add("Type-safe");
        checkedList.add("List");

        System.out.println("Checked list: " + checkedList);

        // Checked Set
        Set<Integer> checkedSet = Collections.checkedSet(new HashSet<>(), Integer.class);
        checkedSet.add(100);
        System.out.println("Checked set: " + checkedSet);

        // Checked Map
        Map<String, Integer> checkedMap = Collections.checkedMap(new HashMap<>(), String.class, Integer.class);
        checkedMap.put("count", 5);
        System.out.println("Checked map: " + checkedMap);

        System.out.println();
    }

    // Empty and singleton examples
    private static void emptyAndSingletonExamples() {
        System.out.println("=== Empty and Singleton Examples ===");

        // Empty collections
        List<String> emptyList = Collections.emptyList();
        Set<String> emptySet = Collections.emptySet();
        Map<String, String> emptyMap = Collections.emptyMap();

        System.out.println("Empty list: " + emptyList);
        System.out.println("Empty set: " + emptySet);
        System.out.println("Empty map: " + emptyMap);

        // Singleton collections (immutable, single element)
        List<String> singletonList = Collections.singletonList("Only");
        Set<String> singletonSet = Collections.singleton("One");
        Map<String, Integer> singletonMap = Collections.singletonMap("key", 1);

        System.out.println("Singleton list: " + singletonList);
        System.out.println("Singleton set: " + singletonSet);
        System.out.println("Singleton map: " + singletonMap);

        // nCopies - immutable list with n copies
        List<String> copies = Collections.nCopies(5, "Repeat");
        System.out.println("nCopies: " + copies);

        System.out.println();
    }

    // Binary search example with custom comparator
    private static void binarySearchExample() {
        System.out.println("=== Binary Search with Comparator ===");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        people.add(new Person("David", 28));

        // Sort by age
        Collections.sort(people, Comparator.comparingInt(p -> p.age));
        System.out.println("Sorted by age: " + people);

        // Binary search by age
        int index = Collections.binarySearch(people, new Person("", 28), Comparator.comparingInt(p -> p.age));
        System.out.println("Person with age 28 at index: " + index);
        if (index >= 0) {
            System.out.println("Found: " + people.get(index));
        }

        System.out.println();
    }

    // Helper class
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}

