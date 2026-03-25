import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println();

        System.out.println("Before Sorting:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }
        System.out.println();

        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("After Sorting by Capacity:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println();
        System.out.println("UC7 sorting completed...");
    }
}
