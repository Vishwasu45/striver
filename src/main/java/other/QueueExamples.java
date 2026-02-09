package other;

import java.util.*;
import java.util.concurrent.*;

/**
 * Demonstrates all Queue and Deque implementations in Java Collections Framework
 */
public class QueueExamples {
    public static void main(String[] args) {
        linkedListQueueExample();
        priorityQueueExample();
        arrayDequeExample();
        priorityBlockingQueueExample();
        linkedBlockingQueueExample();
        arrayBlockingQueueExample();
        delayQueueExample();
        synchronousQueueExample();
        linkedTransferQueueExample();
        concurrentLinkedQueueExample();
        concurrentLinkedDequeExample();
    }

    // LinkedList as Queue - FIFO queue
    private static void linkedListQueueExample() {
        System.out.println("=== LinkedList as Queue Example ===");
        Queue<String> queue = new LinkedList<>();

        // Add elements (throws exception if fails)
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        // Offer (returns false if fails)
        queue.offer("Fourth");

        // Peek (view head without removing)
        System.out.println("Peek: " + queue.peek());

        // Poll (remove and return head)
        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());

        System.out.println("Remaining queue: " + queue);
        System.out.println();
    }

    // PriorityQueue - Queue based on priority heap
    private static void priorityQueueExample() {
        System.out.println("=== PriorityQueue Example ===");

        // Natural ordering (min heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(50);
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);

        System.out.println("Min heap polling:");
        while (!minHeap.isEmpty()) {
            System.out.println("  " + minHeap.poll());
        }

        // Custom comparator (max heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(50);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);

        System.out.println("Max heap polling:");
        while (!maxHeap.isEmpty()) {
            System.out.println("  " + maxHeap.poll());
        }

        // Priority queue with custom objects
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.add(new Task("Low priority task", 3));
        taskQueue.add(new Task("High priority task", 1));
        taskQueue.add(new Task("Medium priority task", 2));

        System.out.println("Task queue polling:");
        while (!taskQueue.isEmpty()) {
            System.out.println("  " + taskQueue.poll());
        }

        System.out.println();
    }

    // ArrayDeque - Resizable array double-ended queue
    private static void arrayDequeExample() {
        System.out.println("=== ArrayDeque Example ===");
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Add to front
        deque.addFirst("Front1");
        deque.offerFirst("Front2");

        // Add to back
        deque.addLast("Back1");
        deque.offerLast("Back2");

        System.out.println("Deque: " + deque);

        // Peek both ends
        System.out.println("Peek first: " + deque.peekFirst());
        System.out.println("Peek last: " + deque.peekLast());

        // Remove from both ends
        System.out.println("Remove first: " + deque.removeFirst());
        System.out.println("Remove last: " + deque.removeLast());

        // Use as Stack
        deque.push("Pushed1");
        deque.push("Pushed2");
        System.out.println("After push: " + deque);
        System.out.println("Pop: " + deque.pop());

        System.out.println("Final deque: " + deque);
        System.out.println();
    }

    // PriorityBlockingQueue - Thread-safe unbounded priority queue
    private static void priorityBlockingQueueExample() {
        System.out.println("=== PriorityBlockingQueue Example ===");
        PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<>();

        pbq.add(30);
        pbq.add(10);
        pbq.add(50);
        pbq.add(20);

        System.out.println("PriorityBlockingQueue polling:");
        try {
            while (!pbq.isEmpty()) {
                System.out.println("  " + pbq.take()); // Blocking operation
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // LinkedBlockingQueue - Thread-safe bounded FIFO queue
    private static void linkedBlockingQueueExample() {
        System.out.println("=== LinkedBlockingQueue Example ===");
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>(3); // Capacity 3

        try {
            lbq.put("First");
            lbq.put("Second");
            lbq.put("Third");

            System.out.println("Queue size: " + lbq.size());
            System.out.println("Remaining capacity: " + lbq.remainingCapacity());

            // offer with timeout
            boolean added = lbq.offer("Fourth", 1, TimeUnit.SECONDS);
            System.out.println("Added Fourth: " + added); // false, queue full

            System.out.println("Taking elements:");
            System.out.println("  " + lbq.take());
            System.out.println("  " + lbq.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // ArrayBlockingQueue - Thread-safe bounded FIFO queue backed by array
    private static void arrayBlockingQueueExample() {
        System.out.println("=== ArrayBlockingQueue Example ===");
        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(3);

        abq.add(100);
        abq.add(200);
        abq.add(300);

        System.out.println("ArrayBlockingQueue: " + abq);
        System.out.println("Size: " + abq.size());

        try {
            System.out.println("Take: " + abq.take());
            abq.put(400);
            System.out.println("After operations: " + abq);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // DelayQueue - Queue of Delayed elements
    private static void delayQueueExample() {
        System.out.println("=== DelayQueue Example ===");
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();

        long now = System.currentTimeMillis();
        delayQueue.add(new DelayedTask("Task 1", now + 1000));  // 1 second delay
        delayQueue.add(new DelayedTask("Task 2", now + 500));   // 0.5 second delay
        delayQueue.add(new DelayedTask("Task 3", now + 1500));  // 1.5 second delay

        System.out.println("Size: " + delayQueue.size());
        System.out.println("Delayed elements are available only after delay expires");

        System.out.println();
    }

    // SynchronousQueue - Queue with no capacity
    private static void synchronousQueueExample() {
        System.out.println("=== SynchronousQueue Example ===");
        SynchronousQueue<String> sq = new SynchronousQueue<>();

        System.out.println("SynchronousQueue has no capacity: " + sq.size());
        System.out.println("Each insert must wait for a corresponding remove");

        // Producer thread
        new Thread(() -> {
            try {
                System.out.println("Producer: Putting element");
                sq.put("Data");
                System.out.println("Producer: Element transferred");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Wait 1 second
                System.out.println("Consumer: Taking element");
                String data = sq.take();
                System.out.println("Consumer: Received " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(2000); // Wait for threads to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // LinkedTransferQueue - Unbounded TransferQueue based on linked nodes
    private static void linkedTransferQueueExample() {
        System.out.println("=== LinkedTransferQueue Example ===");
        LinkedTransferQueue<String> ltq = new LinkedTransferQueue<>();

        ltq.add("A");
        ltq.add("B");
        ltq.add("C");

        System.out.println("LinkedTransferQueue: " + ltq);

        // Check if there are waiting consumers
        System.out.println("Has waiting consumer: " + ltq.hasWaitingConsumer());

        System.out.println("Poll: " + ltq.poll());
        System.out.println("Remaining: " + ltq);

        System.out.println();
    }

    // ConcurrentLinkedQueue - Thread-safe unbounded FIFO queue
    private static void concurrentLinkedQueueExample() {
        System.out.println("=== ConcurrentLinkedQueue Example ===");
        ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<>();

        clq.add(10);
        clq.add(20);
        clq.add(30);
        clq.offer(40);

        System.out.println("ConcurrentLinkedQueue: " + clq);

        System.out.println("Peek: " + clq.peek());
        System.out.println("Poll: " + clq.poll());
        System.out.println("After poll: " + clq);

        System.out.println();
    }

    // ConcurrentLinkedDeque - Thread-safe unbounded deque
    private static void concurrentLinkedDequeExample() {
        System.out.println("=== ConcurrentLinkedDeque Example ===");
        ConcurrentLinkedDeque<String> cld = new ConcurrentLinkedDeque<>();

        cld.addFirst("First");
        cld.addLast("Last");
        cld.addFirst("NewFirst");
        cld.addLast("NewLast");

        System.out.println("ConcurrentLinkedDeque: " + cld);

        System.out.println("Remove first: " + cld.removeFirst());
        System.out.println("Remove last: " + cld.removeLast());
        System.out.println("After removals: " + cld);

        System.out.println();
    }

    // Helper class for PriorityQueue example
    static class Task implements Comparable<Task> {
        String name;
        int priority;

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return name + " (priority: " + priority + ")";
        }
    }

    // Helper class for DelayQueue example
    static class DelayedTask implements Delayed {
        String name;
        long startTime;

        DelayedTask(String name, long startTime) {
            this.name = name;
            this.startTime = startTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = startTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.startTime, ((DelayedTask) o).startTime);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

