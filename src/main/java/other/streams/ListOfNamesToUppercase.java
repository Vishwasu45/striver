package other.streams;

public class ListOfNamesToUppercase {

    public static void main(String[] args) {
        var names = java.util.Arrays.asList("Alice", "Bob", "Charlie");
        var uppercasedNames = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercased Names: " + uppercasedNames);
    }
}
