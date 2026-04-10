import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class UseCase19TrainConsistMgmntTest {

    // Helper method simulating the Binary Search logic [cite: 1524]
    private boolean performBinarySearch(String[] arr, String key) {
        if (arr.length == 0) return false;

        // Ensure data is sorted before searching [cite: 1605, 1625]
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = key.compareTo(arr[mid]);

            if (res == 0) return true;
            if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    @Test
    void testBinarySearch_BogieFound() {
        String[] data = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(performBinarySearch(data, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] data = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(performBinarySearch(data, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] data = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(performBinarySearch(data, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] data = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(performBinarySearch(data, "BG550"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] data = {};
        assertFalse(performBinarySearch(data, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] data = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(performBinarySearch(data, "BG205"));
    }
}