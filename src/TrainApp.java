import java.util.Arrays;

public class TrainApp {

    // --- UC17: Built-in Sorting using Arrays.sort() ---

    public static void sortBogieNames(String[] names) {
        // Built-in alphabetical sorting
        Arrays.sort(names);
    }

    public static void main(String[] args) {

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Perform Built-in Sort
        sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}