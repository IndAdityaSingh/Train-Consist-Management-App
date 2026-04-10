import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UseCase16TrainConsistMgmntTest {

    // Helper method to apply Bubble Sort logic
    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Test
    void testSort_BasicSorting() {
        // Verifies typical unsorted array [cite: 1243, 1244]
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies already sorted array remains unchanged [cite: 1246, 1247]
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_DuplicateValues() {
        // Verifies correct handling of duplicate capacities [cite: 1248, 1249]
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies single element array is unchanged [cite: 1250, 1251]
        int[] input = {50};
        int[] expected = {50};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AllEqualValues() {
        // Verifies array with identical values remains unchanged [cite: 1252, 1253]
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }
}