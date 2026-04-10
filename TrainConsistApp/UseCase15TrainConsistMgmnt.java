/**
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 * This class safely assigns cargo to goods bogies while handling
 * unsafe combinations using structured exception handling blocks.
 * * @author Developer
 * @version 15.0
 */
public class UseCase15TrainConsistMgmnt {

    // CUSTOM RUNTIME EXCEPTION [cite: 1062]
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model [cite: 1066]
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with safety validation [cite: 1072]
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum [cite: 1076]
                if (this.shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                // Executes completion logging regardless of outcome [cite: 1090, 1096]
                System.out.println("Cargo validation completed for " + this.shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("===============================================\n");

        // Test 1: Safe Assignment [cite: 1105, 1106]
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println();

        // Test 2: Unsafe Assignment [cite: 1107, 1108]
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}