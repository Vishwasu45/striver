# Java Collections Framework - Complete Examples

This package contains comprehensive examples demonstrating all implementations of the Java Collections Framework.

## Overview

The Java Collections Framework provides a unified architecture for representing and manipulating collections. It consists of:
- **Interfaces**: Abstract data types representing collections
- **Implementations**: Concrete implementations of collection interfaces
- **Algorithms**: Methods for performing useful computations on collections

## Files Included

### 1. ListExamples.java
Demonstrates all List implementations:
- **ArrayList**: Resizable array implementation, fast random access
- **LinkedList**: Doubly-linked list, efficient insertions/deletions
- **Vector**: Thread-safe ArrayList (legacy, synchronized)
- **Stack**: LIFO stack extending Vector (legacy)
- **CopyOnWriteArrayList**: Thread-safe variant, creates new copy on modification

**Run**: `java -cp build/classes/java/main other.ListExamples`

### 2. SetExamples.java
Demonstrates all Set implementations:
- **HashSet**: Hash table based, no ordering, O(1) operations
- **LinkedHashSet**: Hash table + linked list, maintains insertion order
- **TreeSet**: Red-Black tree based, sorted order, O(log n) operations
- **EnumSet**: Specialized high-performance set for enum types
- **CopyOnWriteArraySet**: Thread-safe set backed by CopyOnWriteArrayList
- **ConcurrentSkipListSet**: Thread-safe sorted set

**Run**: `java -cp build/classes/java/main other.SetExamples`

### 3. MapExamples.java
Demonstrates all Map implementations:
- **HashMap**: Hash table based, no ordering, allows null key/values
- **LinkedHashMap**: Hash table + linked list, maintains insertion/access order
- **TreeMap**: Red-Black tree based, sorted by keys
- **Hashtable**: Synchronized HashMap (legacy), no null key/values
- **IdentityHashMap**: Uses reference equality (==) instead of equals()
- **WeakHashMap**: Weak references for keys, allows garbage collection
- **EnumMap**: Specialized high-performance map for enum keys
- **ConcurrentHashMap**: Thread-safe, high-performance, non-blocking
- **ConcurrentSkipListMap**: Thread-safe sorted map

**Run**: `java -cp build/classes/java/main other.MapExamples`

### 4. QueueExamples.java
Demonstrates all Queue and Deque implementations:
- **LinkedList**: Can be used as FIFO queue
- **PriorityQueue**: Priority heap, elements ordered by priority
- **ArrayDeque**: Resizable array double-ended queue
- **PriorityBlockingQueue**: Thread-safe unbounded priority queue
- **LinkedBlockingQueue**: Thread-safe bounded FIFO queue
- **ArrayBlockingQueue**: Thread-safe bounded queue backed by array
- **DelayQueue**: Queue of delayed elements
- **SynchronousQueue**: Queue with no capacity, each insert waits for remove
- **LinkedTransferQueue**: Unbounded TransferQueue
- **ConcurrentLinkedQueue**: Thread-safe unbounded FIFO queue
- **ConcurrentLinkedDeque**: Thread-safe unbounded deque

**Run**: `java -cp build/classes/java/main other.QueueExamples`

### 5. CollectionsUtilityExamples.java
Demonstrates Collections utility class methods:
- **Sorting**: sort, reverseOrder
- **Searching**: binarySearch
- **Modification**: shuffle, reverse, fill, replaceAll, rotate, swap
- **Composition**: frequency, disjoint, min, max
- **Wrappers**: unmodifiable, synchronized, checked collections
- **Factory methods**: empty, singleton, nCopies

**Run**: `java -cp build/classes/java/main other.CollectionsUtilityExamples`

### 6. AdvancedCollectionOperations.java
Demonstrates advanced collection features:
- **Iterators**: Iterator, ListIterator with bidirectional traversal
- **Comparators**: Natural order, reverse order, custom comparators, chaining
- **Stream Operations**: filter, map, reduce, collect, distinct, sorted
- **Collectors**: toList, toSet, groupingBy, partitioningBy, joining
- **Complex Sorting**: Multi-field sorting with comparator chaining
- **Conversions**: Between List/Set/Array/Map/Stream

**Run**: `java -cp build/classes/java/main other.AdvancedCollectionOperations`

## Collection Hierarchy

```
Collection (Interface)
├── List (Interface)
│   ├── ArrayList
│   ├── LinkedList
│   ├── Vector
│   │   └── Stack
│   └── CopyOnWriteArrayList
│
├── Set (Interface)
│   ├── HashSet
│   ├── LinkedHashSet
│   ├── TreeSet
│   ├── EnumSet
│   ├── CopyOnWriteArraySet
│   └── ConcurrentSkipListSet
│
└── Queue (Interface)
    ├── PriorityQueue
    ├── LinkedList
    ├── ArrayDeque
    ├── PriorityBlockingQueue
    ├── LinkedBlockingQueue
    ├── ArrayBlockingQueue
    ├── DelayQueue
    ├── SynchronousQueue
    ├── LinkedTransferQueue
    ├── ConcurrentLinkedQueue
    └── ConcurrentLinkedDeque

Map (Interface) - Not part of Collection
├── HashMap
├── LinkedHashMap
├── TreeMap
├── Hashtable
├── IdentityHashMap
├── WeakHashMap
├── EnumMap
├── ConcurrentHashMap
└── ConcurrentSkipListMap
```

## Performance Characteristics

### List Implementations
| Operation | ArrayList | LinkedList | Vector | CopyOnWriteArrayList |
|-----------|-----------|------------|--------|----------------------|
| get(i)    | O(1)      | O(n)       | O(1)   | O(1)                 |
| add(e)    | O(1)*     | O(1)       | O(1)*  | O(n)                 |
| add(i,e)  | O(n)      | O(n)       | O(n)   | O(n)                 |
| remove(i) | O(n)      | O(n)       | O(n)   | O(n)                 |
| contains  | O(n)      | O(n)       | O(n)   | O(n)                 |

*Amortized constant time

### Set Implementations
| Operation | HashSet | LinkedHashSet | TreeSet | EnumSet |
|-----------|---------|---------------|---------|---------|
| add       | O(1)    | O(1)          | O(log n)| O(1)    |
| remove    | O(1)    | O(1)          | O(log n)| O(1)    |
| contains  | O(1)    | O(1)          | O(log n)| O(1)    |
| ordering  | None    | Insertion     | Sorted  | Natural |

### Map Implementations
| Operation | HashMap | LinkedHashMap | TreeMap | ConcurrentHashMap |
|-----------|---------|---------------|---------|-------------------|
| get       | O(1)    | O(1)          | O(log n)| O(1)              |
| put       | O(1)    | O(1)          | O(log n)| O(1)              |
| remove    | O(1)    | O(1)          | O(log n)| O(1)              |
| ordering  | None    | Insertion     | Sorted  | None              |

## When to Use What

### List
- **ArrayList**: Default choice, fast random access, use when you need index-based access
- **LinkedList**: Frequent insertions/deletions at beginning or middle
- **Vector/Stack**: Avoid (legacy), use ArrayList with Collections.synchronizedList() or CopyOnWriteArrayList
- **CopyOnWriteArrayList**: Thread-safe, read-heavy workloads with infrequent writes

### Set
- **HashSet**: Default choice, fastest performance, no ordering needed
- **LinkedHashSet**: Need to maintain insertion order
- **TreeSet**: Need sorted order or range operations
- **EnumSet**: Working with enum types (extremely efficient)
- **ConcurrentSkipListSet**: Thread-safe sorted set

### Map
- **HashMap**: Default choice, best performance, allows null
- **LinkedHashMap**: Need insertion/access order (useful for LRU cache)
- **TreeMap**: Need sorted keys or range queries
- **EnumMap**: Enum keys (extremely efficient)
- **ConcurrentHashMap**: Thread-safe, high-concurrency scenarios
- **WeakHashMap**: Cache implementation where entries can be garbage collected

### Queue/Deque
- **ArrayDeque**: General purpose queue/stack (better than LinkedList for queue)
- **PriorityQueue**: Need elements processed by priority
- **LinkedList**: Need both List and Queue operations
- **Blocking Queues**: Producer-consumer patterns in concurrent applications

## Thread Safety

### Thread-Safe Collections
- Vector, Stack, Hashtable (legacy, avoid)
- CopyOnWriteArrayList, CopyOnWriteArraySet
- ConcurrentHashMap, ConcurrentSkipListMap, ConcurrentSkipListSet
- All blocking queues (PriorityBlockingQueue, LinkedBlockingQueue, etc.)

### Synchronized Wrappers
```java
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
```

### Concurrent Collections (Preferred)
```java
List<String> concurrentList = new CopyOnWriteArrayList<>();
Map<String, String> concurrentMap = new ConcurrentHashMap<>();
Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
```

## Best Practices

1. **Program to Interfaces**: Use `List`, `Set`, `Map` interfaces instead of concrete types
   ```java
   List<String> list = new ArrayList<>(); // Good
   ArrayList<String> list = new ArrayList<>(); // Avoid
   ```

2. **Specify Initial Capacity**: For large collections, specify initial capacity to avoid resizing
   ```java
   Map<String, String> map = new HashMap<>(1000);
   ```

3. **Use Immutable Collections**: When collections won't change
   ```java
   List<String> immutable = List.of("a", "b", "c"); // Java 9+
   Set<String> immutable = Set.of("x", "y", "z");
   ```

4. **Choose Right Collection**: Consider access patterns, ordering, thread-safety needs

5. **Prefer Streams for Processing**: Use Java 8+ streams for complex operations
   ```java
   list.stream()
       .filter(s -> s.length() > 5)
       .map(String::toUpperCase)
       .collect(Collectors.toList());
   ```

## Building and Running

### Build the project
```bash
./gradlew build
```

### Run individual examples
```bash
java -cp build/classes/java/main other.ListExamples
java -cp build/classes/java/main other.SetExamples
java -cp build/classes/java/main other.MapExamples
java -cp build/classes/java/main other.QueueExamples
java -cp build/classes/java/main other.CollectionsUtilityExamples
java -cp build/classes/java/main other.AdvancedCollectionOperations
```

## Additional Resources

- [Java Collections Framework Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)
- [Java Collections Tutorial](https://docs.oracle.com/javase/tutorial/collections/)
- [Effective Java by Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)

---

*All examples are fully functional and demonstrate best practices for using the Java Collections Framework.*

