import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String toString() {
        return type + " (" + capacity + ")";
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 50),
                new Bogie("First Class", 90),
                new Bogie("Sleeper", 65)
        );

        int threshold = 60;

        List<Bogie> highCapacity = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        System.out.println("Bogies with capacity > " + threshold + ":");
        highCapacity.forEach(System.out::println);

        System.out.println("\nOriginal Bogie List:");
        bogies.forEach(System.out::println);

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println("\nBogies sorted successfully based on capacity.");
    }
}