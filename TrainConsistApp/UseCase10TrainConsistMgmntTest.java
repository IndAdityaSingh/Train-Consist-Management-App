import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class UseCase10TrainConsistMgmntTest {

    // Helper method to simulate the aggregation logic used in the main application
    private int calculateTotalCapacity(List<UseCase10TrainConsistMgmnt.Bogie> list) {
        return list.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase10TrainConsistMgmnt.Bogie("AC Chair", 56),
                new UseCase10TrainConsistMgmnt.Bogie("First Class", 24),
                new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 70)
        );
        assertEquals(222, calculateTotalCapacity(bogies));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase10TrainConsistMgmnt.Bogie("General", 90),
                new UseCase10TrainConsistMgmnt.Bogie("General", 90)
        );
        assertEquals(180, calculateTotalCapacity(bogies));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72)
        );
        assertEquals(72, calculateTotalCapacity(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        assertEquals(0, calculateTotalCapacity(bogies)); // Should return identity value (0)
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase10TrainConsistMgmnt.Bogie("Custom", 15),
                new UseCase10TrainConsistMgmnt.Bogie("Custom", 25)
        );
        assertEquals(40, calculateTotalCapacity(bogies));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase10TrainConsistMgmnt.Bogie("A", 10),
                new UseCase10TrainConsistMgmnt.Bogie("B", 10),
                new UseCase10TrainConsistMgmnt.Bogie("C", 10)
        );
        assertEquals(30, calculateTotalCapacity(bogies));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("AC Chair", 56));

        calculateTotalCapacity(bogies);

        // Verify original list size and contents remain identical
        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals(72, bogies.get(0).capacity);
    }
}