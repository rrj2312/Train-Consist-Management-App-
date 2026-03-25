import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        // Display Header
        System.out.println("=========================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=========================================");
        System.out.println();

        // Initialize an empty List to store bogies
        List<String> trainConsist = new ArrayList<>();

        // Display Initialization Status
        System.out.println("Train initialized successfully...");

        // Display Initial Bogie Count
        System.out.println("Initial Bogie Count : " + trainConsist.size());

        // Display Current Train Consist (prints empty brackets [] for an empty list)
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println();
        System.out.println("System ready for operations...");
    }
}
