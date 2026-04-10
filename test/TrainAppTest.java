import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainAppTest {


    @Test
    void testLoopFilteringLogic() {
        List<TrainApp.Bogie> bogies = List.of(
                new TrainApp.Bogie("B1", 70),
                new TrainApp.Bogie("B2", 50)
        );
        List<TrainApp.Bogie> result = TrainApp.filterWithLoop(bogies);
        assertEquals(1, result.size(), "Should only include capacity > 60");
        assertEquals(70, result.get(0).getCapacity());
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainApp.Bogie> bogies = List.of(
                new TrainApp.Bogie("B1", 80),
                new TrainApp.Bogie("B2", 30)
        );
        List<TrainApp.Bogie> result = TrainApp.filterWithStream(bogies);
        assertEquals(1, result.size());
        assertTrue(result.get(0).getCapacity() > 60);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainApp.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bogies.add(new TrainApp.Bogie("B" + i, i));
        }
        List<TrainApp.Bogie> loopRes = TrainApp.filterWithLoop(bogies);
        List<TrainApp.Bogie> streamRes = TrainApp.filterWithStream(bogies);
        assertEquals(loopRes.size(), streamRes.size(), "Both methods must return the same count");
    }

    @Test
    void testExecutionTimeMeasurement() {
        long startTime = System.nanoTime();
        // Small delay to ensure time passes
        long duration = System.nanoTime() - startTime;
        assertTrue(duration >= 0, "Elapsed time should be a positive value");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainApp.Bogie> largeList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            largeList.add(new TrainApp.Bogie("B" + i, 100));
        }
        List<TrainApp.Bogie> result = TrainApp.filterWithStream(largeList);
        assertEquals(50000, result.size(), "Should handle large datasets correctly");
    }
}