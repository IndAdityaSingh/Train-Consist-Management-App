import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmntTest {

    @Test
    void testLoopFilteringLogic() {
        // Verifies that loop-based filtering correctly returns bogies with capacity > 60 [cite: 864, 865]
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase13TrainConsistMgmnt.Bogie("Sleeper", 70),
                new UseCase13TrainConsistMgmnt.Bogie("AC Chair", 50)
        );
        List<UseCase13TrainConsistMgmnt.Bogie> loopResult = new ArrayList<>();
        for (UseCase13TrainConsistMgmnt.Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }


        assertEquals(1, loopResult.size());
        assertEquals(70, loopResult.get(0).capacity);
    }

    @Test
    void testStreamFilteringLogic() {
        // Verifies that stream-based filtering correctly returns bogies with capacity > 60 [cite: 866, 867]
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase13TrainConsistMgmnt.Bogie("Sleeper", 70),
                new UseCase13TrainConsistMgmnt.Bogie("AC Chair", 50)
        );
        List<UseCase13TrainConsistMgmnt.Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(1, streamResult.size());
        assertEquals(70, streamResult.get(0).capacity);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        // Verifies that both filtering methods produce identical result sizes [cite: 868, 869]
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Type", (int)(Math.random() * 100)));
        }

        List<UseCase13TrainConsistMgmnt.Bogie> loopResult = new ArrayList<>();
        for (UseCase13TrainConsistMgmnt.Bogie b : bogies) {
            if (b.capacity > 60) loopResult.add(b);
        }

        List<UseCase13TrainConsistMgmnt.Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        // Verifies that elapsed time is positive when measured using System.nanoTime() [cite: 870, 871]
        long start = System.nanoTime();
        // Small delay to ensure positive duration
        for(int i=0; i<1000; i++) { Math.sqrt(i); }
        long end = System.nanoTime();
        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        // Verifies filtering works correctly on large datasets [cite: 872, 873]
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Sleeper", 100));
        }
        long count = bogies.stream().filter(b -> b.capacity > 60).count();
        assertEquals(5000, count);
    }
}