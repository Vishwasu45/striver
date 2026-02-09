package other.streams;

public class SummarizingStatistics {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(5, 10, 15, 20, 25);
        var stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }
}
