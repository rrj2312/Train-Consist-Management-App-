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
}