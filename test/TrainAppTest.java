import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainAppTest {

    // --- UC8 Stream Filtering Tests ---

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        // Tests: Bogies with capacity greater than 70 appear in the result.
        List<TrainApp.Bogie> bogies = List.of(new TrainApp.Bogie("Sleeper", 72));
        List<TrainApp.Bogie> result = TrainApp.filterByCapacity(bogies, 70);
        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        // Tests: Bogies with capacity exactly equal to 70 are excluded.
        List<TrainApp.Bogie> bogies = List.of(new TrainApp.Bogie("Sleeper", 70));
        List<TrainApp.Bogie> result = TrainApp.filterByCapacity(bogies, 70);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        // Tests: Bogies with capacity less than 70 do not appear.
        List<TrainApp.Bogie> bogies = List.of(new TrainApp.Bogie("AC Chair", 56));
        List<TrainApp.Bogie> result = TrainApp.filterByCapacity(bogies, 70);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        // Tests: All matching bogies are returned.
        List<TrainApp.Bogie> bogies = List.of(
                new TrainApp.Bogie("Sleeper", 72),
                new TrainApp.Bogie("General", 90),
                new TrainApp.Bogie("AC Chair", 56)
        );
        List<TrainApp.Bogie> result = TrainApp.filterByCapacity(bogies, 60);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        // Tests: The filtered list is empty when none satisfy condition.
        List<TrainApp.Bogie> bogies = List.of(new TrainApp.Bogie("First Class", 24));
        List<TrainApp.Bogie> result = TrainApp.filterByCapacity(bogies, 80);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        // Tests: All bogies satisfy the condition.
        List<TrainApp.Bogie> bogies = List.of(new TrainApp.Bogie("Sleeper", 72), new TrainApp.Bogie("General", 90));
        List<TrainApp.Bogie> result = TrainApp.filterByCapacity(bogies, 10);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        // Tests: Filtering an empty list returns an empty list without error.
        List<TrainApp.Bogie> bogies = new ArrayList<>();
        List<TrainApp.Bogie> result = TrainApp.filterByCapacity(bogies, 60);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}