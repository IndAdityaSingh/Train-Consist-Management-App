import java.util.HashMap;
import java.util.Map;

/**
 * MAIN CLASS - UseCase6TrainConsistMgmt
 * Use Case 6: Map Bogie to Capacity (HashMap)
 * This class associates each bogie with its seating and
 * load capacity using a key-value mapping structure.
 */
public class UseCase6TrainConsistMgmt {

    public static void main(String[] args) {
        // 1. Display Header
        System.out.println("=========================================");
        System.out.println(" UC6: Map Bogie to Capacity (HashMap)    ");
        System.out.println("=========================================\n");

        // 2. Create a HashMap to store bogie-capacity information
        // String is the Key (Bogie Type), Integer is the Value (Capacity)
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // 3. Insert capacity values using the put() method
        // This binds the bogie name to its specific property (e.g., seats or tons)
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("Cargo", 120);

        // 4. Display the mapping details
        System.out.println("Bogie Capacity Details:");

        // 5. Iterate over the map using entrySet()
        // This allows us to access both the Key and Value in one loop
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 6. Final status message
        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}