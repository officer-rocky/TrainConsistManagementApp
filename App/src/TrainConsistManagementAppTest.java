import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementTest {

    // Test: Bogies with capacity greater than threshold
    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 50),
                new Bogie("First Class", 90)
        );
        int threshold = 70;
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().anyMatch(b -> b.type.equals("Sleeper")));
        assertTrue(filtered.stream().anyMatch(b -> b.type.equals("First Class")));
    }

    // Test: Bogies with capacity exactly equal to threshold
    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 50),
                new Bogie("First Class", 90)
        );
        int threshold = 70;
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertEquals(1, filtered.size());
        assertTrue(filtered.stream().anyMatch(b -> b.type.equals("First Class")));
    }

    // Test: Bogies with capacity lower than threshold
    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 60),
                new Bogie("AC Chair", 50)
        );
        int threshold = 70;
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertEquals(0, filtered.size());
    }

    // Test: Multiple bogies matching the filter
    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("First Class", 90),
                new Bogie("AC Chair", 75)
        );
        int threshold = 70;
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertEquals(3, filtered.size());
    }

    // Test: No bogies matching the filter
    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 50),
                new Bogie("General", 45)
        );
        int threshold = 60;
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertEquals(0, filtered.size());
    }

    // Test: All bogies matching the filter
    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("First Class", 90),
                new Bogie("AC Chair", 75)
        );
        int threshold = 70;
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertEquals(bogies.size(), filtered.size());
    }

    // Test: Filtering an empty bogie list
    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        int threshold = 70;
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertEquals(0, filtered.size());
    }

    // Test: Original list remains unchanged after filtering
    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 50),
                new Bogie("First Class", 90)
        ));
        int threshold = 70;
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertEquals(3, bogies.size());  // Original list size unchanged
        assertEquals(2, filtered.size()); // Filtered list correct
    }
}