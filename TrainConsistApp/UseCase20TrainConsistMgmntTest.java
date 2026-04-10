import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UseCase20TrainConsistMgmntTest {

    // Helper method to simulate the search logic with state validation
    private boolean searchWithValidation(String[] bogieIds, String searchId) {
        // State Validation [cite: 1706]
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search."); // [cite: 1711]
        }

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        // Verifies that searching an empty array throws IllegalStateException [cite: 1736, 1737]
        String[] emptyBogies = {};
        assertThrows(IllegalStateException.class, () -> {
            searchWithValidation(emptyBogies, "BG101"); // [cite: 1738]
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        // Verifies search execution when data is present [cite: 1739, 1740]
        String[] bogies = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            searchWithValidation(bogies, "BG101"); // [cite: 1741]
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        // Verifies successful search after passing validation [cite: 1742, 1743]
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertTrue(searchWithValidation(bogies, "BG205")); // [cite: 1744]
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        // Verifies correct false return when validation passes but ID is missing [cite: 1745, 1746]
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertFalse(searchWithValidation(bogies, "BG999")); // [cite: 1747]
    }

    @Test
    void testSearch_SingleElementValidCase() {
        // Verifies correct behavior for a single-element array [cite: 1748]
        String[] bogies = {"BG101"};
        assertTrue(searchWithValidation(bogies, "BG101")); // [cite: 1749]
    }
}