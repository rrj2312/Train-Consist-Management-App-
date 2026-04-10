import java.util.*;
import java.util.stream.Collectors;

public class TrainApp {

    // --- UC9: Stream Grouping Logic ---

    public static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() { return name; }
        public int getCapacity() { return capacity; }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    /**
     * Groups bogies by their name/type using Stream API.
     * @param bogies The original list.
     * @return A map categorized by bogie name.
     */
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    public static void main(String[] args) {


        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 70));
        bogieList.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        bogieList.forEach(System.out::println);

        // Perform grouping
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogieList);

        System.out.println("\nGrouped Bogies:\n");
        grouped.forEach((type, list) -> {
            System.out.println("Bogie Type: " + type);
            for (Bogie b : list) {
                System.out.println("  Capacity -> " + b.getCapacity());
            }
            System.out.println();
        });

        System.out.println("UC9 grouping completed...");
    }
}