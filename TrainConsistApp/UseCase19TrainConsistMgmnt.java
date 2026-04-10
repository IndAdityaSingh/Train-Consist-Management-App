import java.util.Arrays;

/**
 * Use Case 19: Binary Search for Bogie ID
 * Demonstrates optimized searching using divide-and-conquer on sorted data.
 * * @author Developer
 * @version 19.0
 */
public class UseCase19TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("      UC19 - Binary Search for Bogie ID        ");
        System.out.println("===============================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Precondition: Ensure data is sorted before binary search
        Arrays.sort(bogieIds);

        // Search key
        String key = "BG309";

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Binary Search Logic
        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Compute mid index
            int comparison = key.compareTo(bogieIds[mid]); // Lexicographical check

            if (comparison == 0) {
                found = true;
                break;
            } else if (comparison > 0) {
                low = mid + 1; // Adjust search range
            } else {
                high = mid - 1; // Narrow search range
            }
        }

        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " NOT found in consist.");
        }

        System.out.println("\nUC19 search completed.");
    }
}