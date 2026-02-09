package other.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListFirstNames {

    public static void main(String[] args) {
        List<String> fullNames = Arrays.asList("Alice Johnson", "Bob Harris", "Charlie Lou");
        List<String> firstNames = fullNames.stream()
                .map(name -> name.split(" ")[0])
                .collect(Collectors.toList());
        System.out.println("First Names: " + firstNames);
    }
}
