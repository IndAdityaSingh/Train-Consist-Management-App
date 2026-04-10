import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UseCase14TrainConsistMgmntTest {

    @Test
    void testException_ValidCapacityCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        // Verifies valid capacity instantiation [cite: 988, 989]
        UseCase14TrainConsistMgmnt.PassengerBogie bogie = new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        assertNotNull(bogie); // [cite: 990]
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Verifies that -10 triggers InvalidCapacityException [cite: 991, 992]
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Verifies zero capacity is treated as invalid [cite: 993, 994]
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 0); // [cite: 995]
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        // Verifies message content matches business rules [cite: 996, 997]
        UseCase14TrainConsistMgmnt.InvalidCapacityException exception =
                assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
                    new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 0);
                });
        assertEquals("Capacity must be greater than zero", exception.getMessage()); // [cite: 998]
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        // Verifies object retains correct values [cite: 999, 1000]
        UseCase14TrainConsistMgmnt.PassengerBogie bogie = new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.name);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        // Verifies multiple successful instantiations [cite: 1001, 1002]
        new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", 56);
        new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", 24);
    }
}