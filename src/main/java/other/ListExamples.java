package other;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Demonstrates all List implementations in Java Collections Framework
 */
public class ListExamples {
    public static void main(String[] args) {
        arrayListExample();
        linkedListExample();
        vectorExample();
        stackExample();
        copyOnWriteArrayListExample();
    }

    // ArrayList - Resizable array implementation
    private static void arrayListExample() {
        System.out.println("=== ArrayList Example ===");
        List<String> arrayList = new ArrayList<>();

        // Adding elements
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        arrayList.add(1, "Avocado"); // Insert at index

        // Accessing elements
        System.out.println("Element at index 0: " + arrayList.get(0));

        // Updating elements
        arrayList.set(2, "Blueberry");

        // Removing elements
        arrayList.remove("Cherry");
        arrayList.remove(0);

        // Iterating
        System.out.println("ArrayList contents:");
        for (String fruit : arrayList) {
            System.out.println("  " + fruit);
        }

        // Size and contains
        System.out.println("Size: " + arrayList.size());
        System.out.println("Contains Banana: " + arrayList.contains("Banana"));

        System.out.println();
    }

    // LinkedList - Doubly-linked list implementation
    private static void linkedListExample() {
        System.out.println("=== LinkedList Example ===");
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Adding elements
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.addFirst(5);  // Add at beginning
        linkedList.addLast(40);  // Add at end

        // Access first and last
        System.out.println("First: " + linkedList.getFirst());
        System.out.println("Last: " + linkedList.getLast());

        // Remove first and last
        linkedList.removeFirst();
        linkedList.removeLast();

        // Using as Queue
        linkedList.offer(50);  // Add to end
        System.out.println("Poll (remove from front): " + linkedList.poll());

        // Using as Deque
        linkedList.push(100);  // Add to front (stack operation)
        System.out.println("Pop: " + linkedList.pop());

        System.out.println("LinkedList: " + linkedList);
        System.out.println();
    }

    // Vector - Synchronized resizable array
    private static void vectorExample() {
        System.out.println("=== Vector Example ===");
        Vector<String> vector = new Vector<>();

        // Adding elements
        vector.add("Red");
        vector.add("Green");
        vector.add("Blue");
        vector.addElement("Yellow");  // Legacy method

        // Access elements
        System.out.println("First element: " + vector.firstElement());
        System.out.println("Last element: " + vector.lastElement());

        // Capacity
        System.out.println("Capacity: " + vector.capacity());
        System.out.println("Size: " + vector.size());

        // Enumeration (legacy)
        Enumeration<String> enumeration = vector.elements();
        System.out.println("Vector contents:");
        while (enumeration.hasMoreElements()) {
            System.out.println("  " + enumeration.nextElement());
        }

        System.out.println();
    }

    // Stack - LIFO stack (extends Vector)
    private static void stackExample() {
        System.out.println("=== Stack Example ===");
        Stack<Integer> stack = new Stack<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Peek (view top without removing)
        System.out.println("Peek: " + stack.peek());

        // Pop elements
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        // Search (returns 1-based position from top)
        System.out.println("Position of 10: " + stack.search(10));

        // Check if empty
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Stack: " + stack);

        System.out.println();
    }

    // CopyOnWriteArrayList - Thread-safe variant of ArrayList
    private static void copyOnWriteArrayListExample() {
        System.out.println("=== CopyOnWriteArrayList Example ===");
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();

        // Adding elements
        cowList.add("Thread-Safe");
        cowList.add("No");
        cowList.add("ConcurrentModificationException");

        // Safe iteration even during modification
        for (String s : cowList) {
            System.out.println("  " + s);
            if (s.equals("No")) {
                cowList.add("New Element"); // Safe during iteration
            }
        }

        System.out.println("Final list: " + cowList);
        System.out.println();
    }
}

