import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainAppTest {

    @Test
    void testSort_BasicSorting() {
        // Tests: Array {72, 56, 24, 70, 60} becomes {24, 56, 60, 70, 72}
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        TrainApp.bubbleSortByCapacity(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Tests: {24, 56, 60, 70, 72} remains unchanged
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        TrainApp.bubbleSortByCapacity(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_DuplicateValues() {
        // Tests: {72, 56, 56, 24} becomes {24, 56, 56, 72}
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        TrainApp.bubbleSortByCapacity(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_SingleElementArray() {
        // Tests: {50} remains {50}
        int[] input = {50};
        int[] expected = {50};
        TrainApp.bubbleSortByCapacity(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AllEqualValues() {
        // Tests: {40, 40, 40} remains unchanged
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        TrainApp.bubbleSortByCapacity(input);
        assertArrayEquals(expected, input);
    }
}