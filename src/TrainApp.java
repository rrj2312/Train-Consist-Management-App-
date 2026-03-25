import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Custom Bogie class to hold properties
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

public class TrainApp {
    public static void main(String[] args) {
        // 1. Initializing the original collection
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        // Display Header
        System.out.println("=========================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("=========================================");
        System.out.println();

        // 2. Display all bogies before filtering
        System.out.println("All Bogies:");
        bogieList.forEach(System.out::println);
        System.out.println();

        // 3. Applying Stream API logic to filter based on capacity > 60
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // 4. Display the filtered results
        System.out.println("Filtered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println();
        System.out.println("UC8 filtering completed...");
    }
}
