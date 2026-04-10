import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    // --- UC10: Stream Aggregation (Map-Reduce) Logic ---

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
     * Calculates total seating capacity using map and reduce.
     * @param bogies The list of bogies to aggregate.
     * @return The total sum of capacities.
     */
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity) // Extract capacity (Integer)
                .reduce(0, Integer::sum); // Aggregate using sum starting at 0
    }

    public static void main(String[] args) {


        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        bogieList.forEach(System.out::println);

        // Perform aggregation
        int totalSeats = calculateTotalSeats(bogieList);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);
        System.out.println("\nUC10 aggregation completed...");
    }
}