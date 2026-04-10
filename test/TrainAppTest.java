import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class TrainAppTest {

    // --- UC9 Grouping Tests ---

    @Test
    void testGrouping_BogiesGroupedByType() {
        // Tests: Bogies with the same name appear under the same Map key.
        List<TrainApp.Bogie> list = List.of(new TrainApp.Bogie("Sleeper", 72), new TrainApp.Bogie("Sleeper", 70));
        Map<String, List<TrainApp.Bogie>> result = TrainApp.groupBogiesByType(list);

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        // Tests: Each bogie type appears as a distinct key.
        List<TrainApp.Bogie> list = List.of(new TrainApp.Bogie("AC Chair", 56), new TrainApp.Bogie("First Class", 24));
        Map<String, List<TrainApp.Bogie>> result = TrainApp.groupBogiesByType(list);

        assertEquals(2, result.keySet().size());
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        // Tests: Grouping an empty list returns an empty Map.
        Map<String, List<TrainApp.Bogie>> result = TrainApp.groupBogiesByType(new ArrayList<>());
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        // Tests: Keys match the expected bogie names.
        List<TrainApp.Bogie> list = List.of(new TrainApp.Bogie("Luxury", 10));
        Map<String, List<TrainApp.Bogie>> result = TrainApp.groupBogiesByType(list);
        assertTrue(result.containsKey("Luxury"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        // Tests: Validates exact count in a specific group.
        List<TrainApp.Bogie> list = List.of(
                new TrainApp.Bogie("Sleeper", 72),
                new TrainApp.Bogie("Sleeper", 70),
                new TrainApp.Bogie("AC Chair", 60)
        );
        Map<String, List<TrainApp.Bogie>> result = TrainApp.groupBogiesByType(list);
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        // Tests: The source list remains unchanged after grouping.
        List<TrainApp.Bogie> list = new ArrayList<>(List.of(new TrainApp.Bogie("Sleeper", 72)));
        TrainApp.groupBogiesByType(list);
        assertEquals(1, list.size());
        assertEquals("Sleeper", list.get(0).getName());
    }
}