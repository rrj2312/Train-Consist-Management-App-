import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainAppTest {

    @Test
    void testException_ValidCapacityCreation() {
        // Verifies valid capacity is instantiated without exception
        assertDoesNotThrow(() -> {
            new TrainApp.Bogie("Sleeper", 72);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Verifies capacity value -10 throws InvalidCapacityException
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new TrainApp.Bogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Verifies capacity value 0 throws InvalidCapacityException
        assertThrows(InvalidCapacityException.class, () -> {
            new TrainApp.Bogie("Sleeper", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        // Verifies the specific error message
        try {
            new TrainApp.Bogie("Sleeper", -5);
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        // Verifies bogie properties match constructor parameters
        TrainApp.Bogie bogie = new TrainApp.Bogie("AC", 40);
        assertEquals("AC", bogie.getType());
        assertEquals(40, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        // Verifies multiple valid bogies are created successfully
        assertDoesNotThrow(() -> {
            new TrainApp.Bogie("Sleeper", 72);
            new TrainApp.Bogie("General", 100);
            new TrainApp.Bogie("Pantry", 10);
        });
    }
}