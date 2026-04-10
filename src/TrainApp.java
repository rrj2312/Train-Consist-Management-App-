import java.util.Scanner;
import java.util.regex.Pattern;

public class TrainApp {


    public static boolean isValidTrainId(String trainId) {
        String regex = "^TRN-\\d{4}$";
        return Pattern.matches(regex, trainId);
    }

    /**
     * Validates Cargo Code format: AAA-AA (where A is an uppercase letter)
     */
    public static boolean isValidCargoCode(String cargoCode) {
        // Matches exactly 3 uppercase letters, a hyphen, and 2 uppercase letters
        String regex = "^[A-Z]{3}-[A-Z]{2}$";
        return Pattern.matches(regex, cargoCode);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Inputs
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainIdInput = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCodeInput = scanner.nextLine();

        // Perform Validation
        boolean isTrainValid = isValidTrainId(trainIdInput);
        boolean isCargoValid = isValidCargoCode(cargoCodeInput);

        // Display Results
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}