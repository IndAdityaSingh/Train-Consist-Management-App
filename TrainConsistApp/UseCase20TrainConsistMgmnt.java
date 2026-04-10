/**
 * Use Case 20: Exception Handling During Search Operations
 * This class prevents searching when no bogies exist
 * by applying fail-fast validation using exceptions.
 * * @author Developer
 * @version 20.0
 */
public class UseCase20TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC20 Exception Handling During Search ");
        System.out.println("===============================================\n");

        // Create bogie array (empty train scenario)
        String[] bogieIds = {};

        // Search key
        String searchId = "BG101";

        // FAIL-FAST VALIDATION
        // Check if train has bogies before performing search
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search."); //
        }

        // SEARCH LOGIC (executes only if data exists)
        boolean found = false;
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        // Display result
        if (found) {
            System.out.println("Bogie " + searchId + " found.");
        } else {
            System.out.println("Bogie " + searchId + " not found.");
        }

        System.out.println("\nUC20 execution completed..."); //
    }
}