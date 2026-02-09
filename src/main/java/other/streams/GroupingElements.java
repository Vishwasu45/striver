package other.streams;

public class GroupingElements {

    public static void main(String[] args) {
        var items = java.util.Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");

        var groupedByFirstLetter = items.stream()
                .collect(java.util.stream.Collectors.groupingBy(s -> s.substring(0, 1)));

        System.out.println("Grouped by first letter: " + groupedByFirstLetter);
    }
}
