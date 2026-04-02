import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS - UseCase1TrainConsistMgmt
 * * Use Case 1: Initialize Train and Display Consist Summary
 * This class represents the entry point of the Train Consist Management Application. [cite: 10, 13]
 */
public class UseCase1TrainConsistMgmt {

    public static void main(String[] args) {
        // 1. Display welcome banner [cite: 25, 37, 57]
        System.out.println("=========================================");
        System.out.println("   Train Consist Management App          ");
        System.out.println("=========================================\n");

        // 2. Create a dynamic list to store train bogies [cite: 17, 30, 31, 58]
        // We use the List interface for abstraction and ArrayList for dynamic resizing [cite: 48, 50]
        List<String> trainConsist = new ArrayList<>();

        // 3. Display initial consist information [cite: 32, 33, 66]
        System.out.println("Train initialized successfully....");

        // 4. Display initial bogie count using size() [cite: 18, 39, 59, 67]
        System.out.println("Initial Bogie Count: " + trainConsist.size());

        // 5. Print the current state of the train [cite: 19, 68]
        System.out.println("Current Train Consist: " + trainConsist);

        // 6. Final status message [cite: 69]
        System.out.println("System ready for operations...");
    }
}