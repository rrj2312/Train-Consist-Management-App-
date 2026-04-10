import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class TrainAppTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        // Tests: {"Sleeper","AC Chair","First Class","General","Luxury"}
        // becomes {"AC Chair","First Class","General","Luxury","Sleeper"}
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        TrainApp.sortBogieNames(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_UnsortedInput() {
        // Tests: Rearranging random order into alphabetical
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        TrainApp.sortBogieNames(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Tests: No change for already sorted data
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        TrainApp.sortBogieNames(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        // Tests: {"Sleeper","AC Chair","Sleeper","General"}
        // becomes {"AC Chair","General","Sleeper","Sleeper"}
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        TrainApp.sortBogieNames(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_SingleElementArray() {
        // Tests: Single element remains unchanged
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        TrainApp.sortBogieNames(input);
        assertArrayEquals(expected, input);
    }
}