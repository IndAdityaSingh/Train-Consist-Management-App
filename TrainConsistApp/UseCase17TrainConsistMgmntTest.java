import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class UseCase17TrainConsistMgmntTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        // Verifies typical alphabetical sorting [cite: 1347, 1348]
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_UnsortedInput() {
        // Verifies rearranging of random order names [cite: 1350, 1351]
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies sorted arrays remain unchanged [cite: 1354, 1355]
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        // Verifies handling and ordering of duplicates [cite: 1357, 1358]
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies single element arrays are unaffected [cite: 1360, 1361]
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        Arrays.sort(input);
        assertArrayEquals(expected, input);
    }
}