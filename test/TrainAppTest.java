import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainAppTest {

    // --- UC10 Aggregation Tests ---

    @Test
    void testReduce_TotalSeatCalculation() {
        // Tests: Total equals sum of all capacities.
        List<TrainApp.Bogie> bogies = List.of(
                new TrainApp.Bogie("Sleeper", 72),
                new TrainApp.Bogie("AC Chair", 56)
        );
        assertEquals(128, TrainApp.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        // Tests: Total equals the capacity of the single bogie.
        List<TrainApp.Bogie> bogies = List.of(new TrainApp.Bogie("First Class", 24));
        assertEquals(24, TrainApp.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        // Tests: Empty list returns 0 (the identity value).
        assertEquals(0, TrainApp.calculateTotalSeats(new ArrayList<>()));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        // Tests: Verifies 4+ bogies contributing to sum.
        List<TrainApp.Bogie> bogies = List.of(
                new TrainApp.Bogie("Sleeper", 72),
                new TrainApp.Bogie("AC Chair", 56),
                new TrainApp.Bogie("First Class", 24),
                new TrainApp.Bogie("Sleeper", 70)
        );
        assertEquals(222, TrainApp.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        // Tests: The source list remains unchanged after stream processing.
        List<TrainApp.Bogie> bogies = new ArrayList<>(List.of(new TrainApp.Bogie("Sleeper", 72)));
        TrainApp.calculateTotalSeats(bogies);
        assertEquals(1, bogies.size());
        assertEquals(72, bogies.get(0).getCapacity());
    }
}