import java.util.LinkedHashSet;
import java.util.Set;

/**
 * MAIN CLASS - UseCase5TrainConsistMgmt
 * Use Case 5: Preserve Insertion Order of Bogies
 * This class maintains the exact attachment order of bogies
 * while also preventing duplicate entries using LinkedHashSet.
 */
public class UseCase5TrainConsistMgmt {

    public static void main(String[] args) {
        // 1. Display Header
        System.out.println("=========================================");
        System.out.println(" UC5: Preserve Insertion Order of Bogies ");
        System.out.println("=========================================\n");

        // 2. Create a LinkedHashSet to represent the train formation
        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // 3. Attach bogies in sequence
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // 4. Attempt to attach a duplicate bogie intentionally
        // The add() method will ignore this automatically to protect the consist
        formation.add("Sleeper");

        // 5. Display the final formation order
        // Bogies are returned in the same order they were connected to the engine
        System.out.println("Final Train Formation:");
        System.out.println(formation + "\n");

        // 6. Observation Note
        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}