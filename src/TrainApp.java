<<<<<<< HEAD
public class TrainApp {

    // --- UC18: Linear Search Logic ---

    /**
     * Performs a linear search for a Bogie ID.
     * @param bogieIds The array of IDs to search through.
     * @param targetId The ID to find.
     * @return true if found, otherwise false.
     */
    public static boolean findBogieId(String[] bogieIds, String targetId) {
        for (String id : bogieIds) {
            // Linear search: check every element sequentially
            if (id.equals(targetId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        String[] availableIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String target = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : availableIds) {
            System.out.println(id);
        }

        boolean found = findBogieId(availableIds, target);

        if (found) {
            System.out.println("\nBogie " + target + " found in train consist.");
        } else {
            System.out.println("\nBogie " + target + " not found.");
        }

        System.out.println("\nUC18 search completed...");
    }
=======
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainApp {

    // --- UC8: Stream Filtering Logic ---

    public static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() { return capacity; }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    /**
     * Filters bogies based on a capacity threshold.
     * @param bogies The original list of bogies.
     * @param threshold The capacity limit (exclusive).
     * @return A list of bogies exceeding the threshold.
     */
    public static List<Bogie> filterByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        bogieList.forEach(System.out::println);

        // Applying threshold of 60
        List<Bogie> filtered = filterByCapacity(bogieList, 60);

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filtered.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...");
    }
>>>>>>> feature/UC8
}