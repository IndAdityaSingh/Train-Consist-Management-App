/**
 * Use Case 16: Sort Passenger Bogies by Capacity
 * This class demonstrates manual sorting using the Bubble Sort algorithm.
 * * @author Developer
 * @version 16.0
 */
public class UseCase16TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC16 Manual Sorting using Bubble Sort ");
        System.out.println("===============================================\n");

        // Create array of passenger bogie capacities [cite: 1183, 1211]
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order [cite: 1185]
        System.out.print("Original Capacities: ");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();

        // BUBBLE SORT LOGIC [cite: 1188, 1212]
        // Outer loop controls the number of passes
        for (int i = 0; i < capacities.length - 1; i++) {
            // Inner loop compares adjacent elements
            for (int j = 0; j < capacities.length - 1 - i; j++) {
                // Swap if the left element is greater than the right element [cite: 1213]
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Display sorted result [cite: 1192, 1215]
        System.out.print("Sorted Capacities (Ascending): ");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");
    }
}