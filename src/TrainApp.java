import java.util.ArrayList;
import java.util.List;

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
        // 1. Initializing the list with the exact data from the image
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 70));

        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println();

        System.out.println("Bogies in Train:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }
        System.out.println();


        int totalSeats = bogieList.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity of Train: " + totalSeats);
        System.out.println();
        System.out.println("UC10 aggregation completed...");
    }
}
