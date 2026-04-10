import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainAppTest {

    // --- UC18 Search Tests ---

    @Test
    void testSearch_BogieFound() {
        // Tests: Searching "BG309" in the list returns true.
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainApp.findBogieId(ids, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        // Tests: Searching "BG999" (not in list) returns false.
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(TrainApp.findBogieId(ids, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        // Tests: Match at the first position (Index 0).
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainApp.findBogieId(ids, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        // Tests: Match at the very last position.
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainApp.findBogieId(ids, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        // Tests: Searching when only one ID exists.
        String[] ids = {"BG101"};
        assertTrue(TrainApp.findBogieId(ids, "BG101"));
        assertFalse(TrainApp.findBogieId(ids, "BG205"));
    }
}