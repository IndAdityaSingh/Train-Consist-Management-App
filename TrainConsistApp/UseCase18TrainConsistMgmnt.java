/**
 * Use Case 18: Linear Search for Bogie ID
 * This class demonstrates searching for a specific bogie ID
 * using a simple Linear Search algorithm.
 * * @author Developer
 * @version 18.0
 */
public class UseCase18TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("===============================================\n");

        // 1. User provides a list of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. User provides a search key
        String searchId = "BG309";

        // Display all available bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // LINEAR SEARCH LOGIC
        // Traverse each element sequentially
        boolean found = false;
        for (String id : bogieIds) {
            // Compare each ID using equals()
            if (id.equals(searchId)) {
                found = true;
                break; // Early Termination once match is found
            }
        }

        // 6. Result is displayed
        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found in train consist.");
        }

        System.out.println("UC18 search completed...");
    }
}