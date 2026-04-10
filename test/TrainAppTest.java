import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainAppTest {

    // --- UC11 Regex Tests ---

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainApp.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainApp.isValidTrainId("TRAIN12"));
        assertFalse(TrainApp.isValidTrainId("TRN12A"));
        assertFalse(TrainApp.isValidTrainId("1234-TRN"));
    }

    // --- UC12 Safety Compliance Tests ---

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainApp.GoodsBogie("Cylindrical", "Petroleum"));
        assertTrue(TrainApp.checkSafety(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainApp.GoodsBogie("Cylindrical", "Coal"));
        assertFalse(TrainApp.checkSafety(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainApp.GoodsBogie("Open", "Coal"));
        bogies.add(new TrainApp.GoodsBogie("Box", "Grain"));
        assertTrue(TrainApp.checkSafety(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainApp.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainApp.GoodsBogie("Cylindrical", "Coal"));
        assertFalse(TrainApp.checkSafety(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainApp.GoodsBogie> bogies = new ArrayList<>();
        assertTrue(TrainApp.checkSafety(bogies));
    }
}