import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmntTest {

    private Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> groupBogies(List<UseCase9TrainConsistMgmnt.Bogie> list) {
        return list.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72)
        );
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = groupBogies(bogies);
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(1, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 70)
        );
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = groupBogies(bogies);
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56)
        );
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = groupBogies(bogies);
        assertEquals(2, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = groupBogies(bogies);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase9TrainConsistMgmnt.Bogie("First Class", 24),
                new UseCase9TrainConsistMgmnt.Bogie("First Class", 20)
        );
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = groupBogies(bogies);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56),
                new UseCase9TrainConsistMgmnt.Bogie("First Class", 24)
        );
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = groupBogies(bogies);
        assertTrue(result.keySet().containsAll(List.of("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 70),
                new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56)
        );
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = groupBogies(bogies);
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("General", 90));

        groupBogies(bogies);
        assertEquals(2, bogies.size());
    }
}