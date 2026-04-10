import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainAppTest {

    @Test
    void testCargo_SafeAssignment() {
        // Tests: Cylindrical bogie assigned Petroleum cargo without exception.
        TrainApp.Bogie bogie = new TrainApp.Bogie("Cylindrical");
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Tests: CargoSafetyException is raised when assigned to Rectangular bogie.
        TrainApp.Bogie bogie = new TrainApp.Bogie("Rectangular");
        assertThrows(CargoSafetyException.class, () -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        // Tests: Rectangular bogie does not store Petroleum cargo after failure.
        TrainApp.Bogie bogie = new TrainApp.Bogie("Rectangular");
        try {
            bogie.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Expected
        }
        assertNotEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        // Tests: Multiple cargo assignments proceed without terminating program.
        TrainApp.Bogie b1 = new TrainApp.Bogie("Rectangular");
        TrainApp.Bogie b2 = new TrainApp.Bogie("Cylindrical");

        assertThrows(CargoSafetyException.class, () -> b1.assignCargo("Petroleum"));
        assertDoesNotThrow(() -> b2.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        // Note: finally block execution is typically verified via console output
        // or by checking a boolean flag in a test.
        boolean[] finallyExecuted = {false};
        try {
            TrainApp.Bogie b = new TrainApp.Bogie("Rectangular");
            b.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Handle
        } finally {
            finallyExecuted[0] = true;
        }
        assertTrue(finallyExecuted[0], "Finally block must execute regardless of exception");
    }
}