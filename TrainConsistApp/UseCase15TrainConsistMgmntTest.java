import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UseCase15TrainConsistMgmntTest {

    @Test
    void testCargo_SafeAssignment() {
        // Verifies that safe cargo assignments proceed without error [cite: 1122]
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Verifies that unsafe combinations are caught and error messages shown [cite: 1125]
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");

        // Use a stream to capture output to verify the error message was printed
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bogie.assignCargo("Petroleum");

        assertTrue(outContent.toString().contains("Error: Unsafe cargo assignment!"));
        System.setOut(System.out); // Reset standard output
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        // Verifies that invalid cargo is not stored in the object [cite: 1127]
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo); // Cargo should remain null due to exception
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        // Verifies system stability after a failure [cite: 1129]
        UseCase15TrainConsistMgmnt.GoodsBogie bogie1 = new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        UseCase15TrainConsistMgmnt.GoodsBogie bogie2 = new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum"); // Fails
        bogie2.assignCargo("Petroleum"); // Should still proceed

        assertEquals("Petroleum", bogie2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        // Verifies completion message prints regardless of success [cite: 1131]
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bogie.assignCargo("Petroleum");

        assertTrue(outContent.toString().contains("Cargo validation completed"));

    }
}