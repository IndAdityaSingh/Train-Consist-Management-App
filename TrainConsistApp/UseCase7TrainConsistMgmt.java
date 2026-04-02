import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * DATA CLASS - Bogie
 * Represents a train bogie with a name and seating capacity.
 */
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

/**
 * MAIN CLASS - UseCase7TrainConsistMgmt
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 * This class demonstrates sorting a list of bogie objects
 * based on their capacity using a custom Comparator.
 */
public class UseCase7TrainConsistMgmt {

    public static void main(String[] args) {
        // 1. Display Header
        System.out.println("=========================================");
        System.out.println(" UC7: Sort Bogies by Capacity (Comparator)");
        System.out.println("=========================================\n");

        // 2. Create a List to store Bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();

        // 3. Add bogies with different capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        // 4. Display bogies before sorting
        System.out.println("Before Sorting:");
        passengerBogies.forEach(System.out::println);

        // 5. SORT: Apply Comparator logic to rearrange elements
        // We use Comparator.comparingInt to sort by the capacity field
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        // 6. Display bogies after sorting
        System.out.println("\nAfter Sorting by Capacity:");
        passengerBogies.forEach(System.out::println);

        // 7. Final status message
        System.out.println("\nUC7 sorting completed...");
    }
}