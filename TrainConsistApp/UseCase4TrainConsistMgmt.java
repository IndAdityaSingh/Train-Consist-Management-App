import java.util.LinkedList;
import java.util.List;

/**
 * MAIN CLASS - UseCase4TrainConsistMgmt
 * Use Case 4: Maintain Ordered Bogie Consist
 * This class models the physical chaining of train bogies
 * using LinkedList for ordered operations.
 */
public class UseCase4TrainConsistMgmt {

    public static void main(String[] args) {
        // 1. Display Header
        System.out.println("=========================================");
        System.out.println(" UC4: Maintain Ordered Bogie Consist ");
        System.out.println("=========================================\n");

        // 2. Create a LinkedList to maintain insertion order
        // LinkedList allows fast inserts and removals at any position
        LinkedList<String> trainConsist = new LinkedList<>();

        // 3. ADD: Build the initial train in sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // 4. READ: Display initial consist
        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist + "\n");

        // 5. UPDATE: Insert a 'Pantry Car' at position 2 (0-based index)
        trainConsist.add(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist + "\n");

        // 6. DELETE: Remove the first and last bogie
        trainConsist.removeFirst(); // Detaches the head
        trainConsist.removeLast();  // Detaches the tail

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist + "\n");

        // 7. Final status message
        System.out.println("UC4 ordered consist operations completed...");
    }
}