import java.util.Arrays;

/**
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * Demonstrates alphabetical sorting using Java's built-in optimized utilities.
 * * @author Developer
 * @version 17.0
 */
public class UseCase17TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort() ");
        System.out.println("===============================================\n");

        // Create an array of bogie type names [cite: 1316]
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Display original order using Arrays.toString() [cite: 1319]
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Use Arrays.sort() to sort alphabetically [cite: 1317]
        Arrays.sort(bogieNames);

        // Display sorted result [cite: 1294, 1319]
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}