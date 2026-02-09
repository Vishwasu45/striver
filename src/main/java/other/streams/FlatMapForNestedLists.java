package other.streams;

public class FlatMapForNestedLists {

    public static void main(String[] args) {
        var nestedLists = java.util.Arrays.asList(
                java.util.Arrays.asList(1, 2, 3),
                java.util.Arrays.asList(4, 5),
                java.util.Arrays.asList(6, 7, 8, 9)
        );

        var flatList = nestedLists.stream()
                .flatMap(java.util.List::stream)
                .toList();

        System.out.println("Flattened List: " + flatList);
    }
}
