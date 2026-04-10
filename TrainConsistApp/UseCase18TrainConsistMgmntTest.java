import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UseCase18TrainConsistMgmntTest {

    // Helper method to apply Linear Search logic [cite: 1436]
    private boolean linearSearch(String[] array, String key) {
        for (String element : array) {
            if (element.equals(key)) {
                return true; // Match Found [cite: 1468]
            }
        }
        return false; // Match Not Found [cite: 1470]
    }

    @Test
    void testSearch_BogieFound() {
        // Verifies successful identification of an existing bogie ID [cite: 1477, 1478]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        // Verifies negative result when the ID does not exist [cite: 1480, 1481]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(linearSearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        // Verifies correct detection at the first position [cite: 1483, 1484]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        // Verifies correct detection at the last position [cite: 1486, 1487]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(bogieIds, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        // Verifies search works with a single bogie ID [cite: 1489, 1490]
        String[] bogieIds = {"BG101"};
        assertTrue(linearSearch(bogieIds, "BG101"));
        assertFalse(linearSearch(bogieIds, "BG205"));
    }
}