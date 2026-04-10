/**
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 * This class prevents creation of passenger bogies with invalid seating
 * capacity using a custom exception.
 */
public class UseCase14TrainConsistMgmnt {

    // Custom Exception extending Exception for checked behavior [cite: 928, 937, 952]
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String name;
        int capacity;

        // Constructor validates capacity and throws exception if invalid [cite: 918, 919, 959]
        PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero"); // [cite: 944, 953, 984]
            }
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("===============================================\n");

        // Attempting valid bogie creation [cite: 971, 978]
        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + validBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Attempting invalid bogie creation [cite: 972, 982]
        try {
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", 0);
            System.out.println("Created Bogie: " + invalidBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage()); // [cite: 972]
        }

        System.out.println("\nUC14 exception handling completed...."); // [cite: 973]
    }
}