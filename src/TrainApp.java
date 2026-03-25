import java.util.*;
import java.util.stream.Collectors;

// Bogie class to hold the name and capacity
class Bogie {
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

public class TrainApp {
    public static void main(String[] args) {
        // 1. Initializing the list exactly as shown in the output image
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 70));
        bogieList.add(new Bogie("AC Chair", 60));

        // Header Formatting
        System.out.println("================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("================================");
        System.out.println();

        // 2. Display "All Bogies" section
        System.out.println("All Bogies:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }
        System.out.println();

        // 3. Using Collectors.groupingBy to categorize the bogies
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 4. Display "Grouped Bogies" section
        System.out.println("Grouped Bogies:");
        System.out.println();

        groupedBogies.forEach((type, list) -> {
            System.out.println("Bogie Type: " + type);
            for (Bogie b : list) {
                System.out.println("  Capacity -> " + b.getCapacity());
            }
            System.out.println();
        });

        // Final message
        System.out.println("UC9 grouping completed...");
    }
}
