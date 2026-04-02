import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Create HashSet for bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Adding bogie IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // Duplicate
        bogieIds.add("BG102"); // Duplicate

        // Display unique bogie IDs
        System.out.println("\nBogie IDs after insertion (duplicates ignored):");
        System.out.println(bogieIds);

        // Program continues
        System.out.println("\nAll bogie IDs are unique.");
    }
}