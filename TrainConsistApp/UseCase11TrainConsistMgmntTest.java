import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmntTest {

    // Helper methods to simulate the Regex validation logic used in the main application
    private boolean validateTrainId(String trainId) {
        if (trainId == null) return false;
        return Pattern.matches("^TRN-\\d{4}$", trainId);
    }

    private boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        return Pattern.matches("^PET-[A-Z]{2}$", cargoCode);
    }

    @Test
    void testRegex_ValidTrainID() {
        // Verifies that a Train ID following the correct format is accepted
        assertTrue(validateTrainId("TRN-1234"));
        assertTrue(validateTrainId("TRN-9999"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Verifies that incorrectly formatted Train IDs are rejected
        assertFalse(validateTrainId("TRAIN12"));
        assertFalse(validateTrainId("TRN12A"));
        assertFalse(validateTrainId("1234-TRN"));
        assertFalse(validateTrainId("trn-1234")); // Case sensitivity
    }

    @Test
    void testRegex_ValidCargoCode() {
        // Verifies that a Cargo Code following the correct format is accepted
        assertTrue(validateCargoCode("PET-AB"));
        assertTrue(validateCargoCode("PET-XY"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        // Verifies that incorrectly formatted Cargo Codes are rejected
        assertFalse(validateCargoCode("PET-ab"));
        assertFalse(validateCargoCode("PET123"));
        assertFalse(validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Verifies that Train ID contains exactly four digits after the prefix
        assertFalse(validateTrainId("TRN-123"));   // Too short
        assertFalse(validateTrainId("TRN-12345")); // Too long
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        // Verifies that Cargo Code accepts only uppercase alphabet characters
        assertFalse(validateCargoCode("PET-aB"));
        assertFalse(validateCargoCode("PET-Ab"));
        assertFalse(validateCargoCode("pet-AB")); // Prefix must also be exact
    }

    @Test
    void testRegex_EmptyInputHandling() {
        // Verifies behavior when empty strings are provided as input
        assertFalse(validateTrainId(""));
        assertFalse(validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Verifies that the matches() method checks the entire input string
        assertFalse(validateTrainId("TRN-1234 ")); // Trailing space
        assertFalse(validateTrainId(" TRN-1234")); // Leading space
        assertFalse(validateCargoCode("PET-ABC")); // Extra character
    }
}