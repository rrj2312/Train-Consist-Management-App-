import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainAppTest {

    @Test
    void testRegex_ValidTrainID() {
        // Tests: Train ID TRN-1234 returns a valid result.
        assertTrue(TrainApp.isValidTrainId("TRN-1234"), "Standard valid Train ID should pass");
        assertTrue(TrainApp.isValidTrainId("TRN-6524"), "Screenshot example should pass");
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Tests: Inputs such as TRAIN12, TRN12A, or 1234-TRN are marked invalid.
        assertFalse(TrainApp.isValidTrainId("TRAIN12"), "Missing hyphen and wrong length should fail");
        assertFalse(TrainApp.isValidTrainId("TRN12A"), "Alphanumeric characters instead of digits should fail");
        assertFalse(TrainApp.isValidTrainId("1234-TRN"), "Reversed format should fail");
    }

    @Test
    void testRegex_ValidCargoCode() {
        // Tests: Cargo Code PET-AB returns a valid result.
        assertTrue(TrainApp.isValidCargoCode("PET-AB"), "Standard valid Cargo Code should pass");
        assertTrue(TrainApp.isValidCargoCode("PET-FH"), "Screenshot example should pass");
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        // Tests: Inputs such as PET-ab, PET123, or AB-PET are marked invalid.
        assertFalse(TrainApp.isValidCargoCode("PET-ab"), "Lowercase letters should fail");
        assertFalse(TrainApp.isValidCargoCode("PET123"), "Digits in cargo code should fail");
        assertFalse(TrainApp.isValidCargoCode("AB-PET"), "Reversed character counts should fail");
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Tests: TRN-123 and TRN-12345 are rejected.
        assertFalse(TrainApp.isValidTrainId("TRN-123"), "3 digits (too short) should fail");
        assertFalse(TrainApp.isValidTrainId("TRN-12345"), "5 digits (too long) should fail");
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        // Verifies that Cargo Code accepts only uppercase alphabet characters.
        assertFalse(TrainApp.isValidCargoCode("pet-FH"), "Partial lowercase should fail");
        assertFalse(TrainApp.isValidCargoCode("PET-fh"), "Partial lowercase should fail");
    }

    @Test
    void testRegex_EmptyInputHandling() {
        // Tests: Empty Train ID and Cargo Code return invalid validation results.
        assertFalse(TrainApp.isValidTrainId(""), "Empty Train ID should fail");
        assertFalse(TrainApp.isValidCargoCode(""), "Empty Cargo Code should fail");
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Verifies that the matches() method checks the entire input string.
        // Tests: Strings containing extra characters beyond the pattern are rejected.
        assertFalse(TrainApp.isValidTrainId("TRN-1234 "), "Trailing space should fail");
        assertFalse(TrainApp.isValidTrainId("INFO:TRN-1234"), "Leading text should fail");
        assertFalse(TrainApp.isValidCargoCode(" PET-AB"), "Leading space should fail");
    }
}