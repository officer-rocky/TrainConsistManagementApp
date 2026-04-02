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
    }
}