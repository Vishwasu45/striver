package other;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Demonstrates advanced collection operations including streams, comparators, and iterators
 */
public class AdvancedCollectionOperations {
    public static void main(String[] args) {
        iteratorExamples();
        listIteratorExamples();
        comparatorExamples();
        streamOperationsExample();
        collectorsExample();
        sortingComplexObjects();
        collectionConversions();
    }

    // Iterator examples
    private static void iteratorExamples() {
        System.out.println("=== Iterator Examples ===");

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));

        // Basic iteration
        Iterator<String> iterator = list.iterator();
        System.out.println("Iterating forward:");
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("  " + element);

            // Remove elements during iteration
            if (element.equals("C")) {
                iterator.remove();
            }
        }
        System.out.println("After removing C: " + list);

        // ForEachRemaining (Java 8+)
        iterator = list.iterator();
        System.out.println("Using forEachRemaining:");
        iterator.forEachRemaining(e -> System.out.println("  " + e));

        System.out.println();
    }

    // ListIterator examples
    private static void listIteratorExamples() {
        System.out.println("=== ListIterator Examples ===");

        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        // Forward iteration with index
        ListIterator<Integer> listIterator = list.listIterator();
        System.out.println("Forward iteration:");
        while (listIterator.hasNext()) {
            int index = listIterator.nextIndex();
            int element = listIterator.next();
            System.out.println("  Index " + index + ": " + element);
        }

        // Backward iteration
        System.out.println("Backward iteration:");
        while (listIterator.hasPrevious()) {
            int index = listIterator.previousIndex();
            int element = listIterator.previous();
            System.out.println("  Index " + index + ": " + element);
        }

        // Modify during iteration
        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            int element = listIterator.next();
            if (element == 30) {
                listIterator.set(300); // Replace current element
            }
            if (element == 40) {
                listIterator.add(35); // Add element before current
            }
        }
        System.out.println("After modifications: " + list);

        System.out.println();
    }

    // Comparator examples
    private static void comparatorExamples() {
        System.out.println("=== Comparator Examples ===");

        List<Student> students = Arrays.asList(
            new Student("Alice", 85, 20),
            new Student("Bob", 90, 22),
            new Student("Charlie", 85, 21),
            new Student("David", 90, 20)
        );

        // Sort by grade (descending)
        students.sort(Comparator.comparingInt(Student::getGrade).reversed());
        System.out.println("Sorted by grade (desc): " + students);

        // Sort by grade (desc), then by age (asc)
        students.sort(Comparator.comparingInt(Student::getGrade).reversed()
                                .thenComparingInt(Student::getAge));
        System.out.println("Sorted by grade desc, then age asc: " + students);

        // Sort by name
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Sorted by name: " + students);

        // Natural order comparator
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        numbers.sort(Comparator.naturalOrder());
        System.out.println("Natural order: " + numbers);

        // Reverse order comparator
        numbers.sort(Comparator.reverseOrder());
        System.out.println("Reverse order: " + numbers);

        // Null-safe comparator
        List<String> withNulls = new ArrayList<>(Arrays.asList("A", null, "B", null, "C"));
        withNulls.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("Nulls first: " + withNulls);

        withNulls.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("Nulls last: " + withNulls);

        System.out.println();
    }

    // Stream operations example
    private static void streamOperationsExample() {
        System.out.println("=== Stream Operations Examples ===");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter and collect
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Map and collect
        List<Integer> squared = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("Squared: " + squared);

        // Reduce
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // Count
        long count = numbers.stream()
            .filter(n -> n > 5)
            .count();
        System.out.println("Count > 5: " + count);

        // Distinct
        List<Integer> duplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        List<Integer> distinct = duplicates.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Distinct: " + distinct);

        // Limit and skip
        List<Integer> limited = numbers.stream()
            .skip(2)
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("Skip 2, limit 5: " + limited);

        // Sorted
        List<Integer> sorted = Arrays.asList(5, 2, 8, 1, 9).stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted: " + sorted);

        // Min and max
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Min: " + min.orElse(0));
        System.out.println("Max: " + max.orElse(0));

        // AnyMatch, allMatch, noneMatch
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("Any even: " + anyEven);
        System.out.println("All positive: " + allPositive);
        System.out.println("None negative: " + noneNegative);

        System.out.println();
    }

    // Collectors example
    private static void collectorsExample() {
        System.out.println("=== Collectors Examples ===");

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Date");

        // Collect to Set
        Set<String> fruitSet = fruits.stream().collect(Collectors.toSet());
        System.out.println("To Set: " + fruitSet);

        // Collect to specific collection
        LinkedList<String> linkedList = fruits.stream()
            .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("To LinkedList: " + linkedList);

        // Joining
        String joined = fruits.stream()
            .collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);

        // Counting
        long count = fruits.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        // Grouping by
        Map<Integer, List<String>> byLength = fruits.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + byLength);

        // Partitioning by
        Map<Boolean, List<String>> partitioned = fruits.stream()
            .collect(Collectors.partitioningBy(f -> f.length() > 5));
        System.out.println("Partitioned by length > 5: " + partitioned);

        // Counting occurrences
        Map<String, Long> frequency = fruits.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency: " + frequency);

        // Summarizing
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = numbers.stream()
            .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Statistics: " + stats);

        System.out.println();
    }

    // Sorting complex objects
    private static void sortingComplexObjects() {
        System.out.println("=== Sorting Complex Objects ===");

        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 75000),
            new Employee("Bob", "HR", 65000),
            new Employee("Charlie", "IT", 80000),
            new Employee("David", "HR", 70000),
            new Employee("Eve", "Finance", 90000)
        );

        // Sort by department, then by salary descending
        employees.sort(Comparator.comparing(Employee::getDepartment)
                                 .thenComparing(Comparator.comparing(Employee::getSalary).reversed()));

        System.out.println("Sorted by department, then salary desc:");
        employees.forEach(System.out::println);

        // Group by department and find highest paid
        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
            ));

        System.out.println("\nHighest paid by department:");
        highestPaidByDept.forEach((dept, emp) ->
            System.out.println("  " + dept + ": " + emp.orElse(null))
        );

        System.out.println();
    }

    // Collection conversions
    private static void collectionConversions() {
        System.out.println("=== Collection Conversions ===");

        // List to Set
        List<String> list = Arrays.asList("A", "B", "C", "A", "B");
        Set<String> set = new HashSet<>(list);
        System.out.println("List to Set: " + set);

        // Set to List
        List<String> listFromSet = new ArrayList<>(set);
        System.out.println("Set to List: " + listFromSet);

        // Array to List
        String[] array = {"X", "Y", "Z"};
        List<String> listFromArray = Arrays.asList(array);
        System.out.println("Array to List: " + listFromArray);

        // List to Array
        String[] arrayFromList = list.toArray(new String[0]);
        System.out.println("List to Array: " + Arrays.toString(arrayFromList));

        // Map keys/values to List
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        List<String> keys = new ArrayList<>(map.keySet());
        List<Integer> values = new ArrayList<>(map.values());
        System.out.println("Map keys: " + keys);
        System.out.println("Map values: " + values);

        // Stream to various collections
        List<Integer> streamToList = Arrays.stream(new int[]{1, 2, 3, 4, 5})
            .boxed()
            .collect(Collectors.toList());
        System.out.println("Stream to List: " + streamToList);

        System.out.println();
    }

    // Helper classes
    static class Student {
        private String name;
        private int grade;
        private int age;

        public Student(String name, int grade, int age) {
            this.name = name;
            this.grade = grade;
            this.age = age;
        }

        public String getName() { return name; }
        public int getGrade() { return grade; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return name + "(" + grade + "," + age + ")";
        }
    }

    static class Employee {
        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + " (" + department + ", $" + salary + ")";
        }
    }
}

