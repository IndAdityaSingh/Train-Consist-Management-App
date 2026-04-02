import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS - UseCase2TrainConsistMgmt
 * Use Case 2: Add Passenger Bogies to Train
 * This class demonstrates how passenger bogies can be managed
 * dynamically using ArrayList operations. [cite: 86, 87, 89]
 */
public class UseCase2TrainConsistMgmt {

    public static void main(String[] args) {
        // 1. Display Header
        System.out.println("=========================================");
        System.out.println(" UC2: Add Passenger Bogies to Train      ");
        System.out.println("=========================================\n");
        // 2. CREATE: Initialize ArrayList to hold passenger bogies [cite: 98, 99, 101, 122]
        List<String> passengerBogies = new ArrayList<>();

        // 3. ADD: Attach new bogies to the train [cite: 102, 103, 116, 123]
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 4. READ: Display the list after insertion [cite: 109, 125, 136]
        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies: " + passengerBogies + "\n");
        // 5. DELETE: Remove an existing bogie [cite: 90, 110, 117, 127]
        String bogieToRemove = "AC Chair";
        passengerBogies.remove(bogieToRemove);
        System.out.println("After Removing '" + bogieToRemove + "':");
        System.out.println("Passenger Bogies: " + passengerBogies + "\n");

        // 6. SEARCH: Check for bogie availability using contains() [cite: 91, 111, 118, 128]
        String bogieToCheck = "Sleeper";
        boolean exists = passengerBogies.contains(bogieToCheck);
        System.out.println("Checking if '" + bogieToCheck + "' exists:");
        System.out.println("Contains " + bogieToCheck + "?: " + exists + "\n");

        // 7. Final State: Display the final consist [cite: 91, 129, 142]
        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully...");
    }
}