import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8TrainConsistMgmntTest {

    private List<UseCase8TrainConsistMgmnt.Bogie> filterBogies(List<UseCase8TrainConsistMgmnt.Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmnt.Bogie("General", 90)
        );
        List<UseCase8TrainConsistMgmnt.Bogie> result = filterBogies(bogies, 70);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(new UseCase8TrainConsistMgmnt.Bogie("Test", 70));
        List<UseCase8TrainConsistMgmnt.Bogie> result = filterBogies(bogies, 70);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 56));
        List<UseCase8TrainConsistMgmnt.Bogie> result = filterBogies(bogies, 70);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmnt.Bogie("General", 90),
                new UseCase8TrainConsistMgmnt.Bogie("Express", 85)
        );
        List<UseCase8TrainConsistMgmnt.Bogie> result = filterBogies(bogies, 60);
        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(new UseCase8TrainConsistMgmnt.Bogie("First Class", 24));
        List<UseCase8TrainConsistMgmnt.Bogie> result = filterBogies(bogies, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        List<UseCase8TrainConsistMgmnt.Bogie> result = filterBogies(bogies, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("General", 90));

        filterBogies(bogies, 80);
        assertEquals(2, bogies.size());
    }
} // <--- Make sure this final brace is present!