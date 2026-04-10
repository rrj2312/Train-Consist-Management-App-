import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class TrainApp {

    public static class Bogie {
        private String type;
        private int capacity;

        public Bogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() { return type; }
        public int getCapacity() { return capacity; }
    }

    public static void main(String[] args) {

        String type = "Sleeper";
        int capacity = -72; // Example of invalid input

        try {
            System.out.println("Attempting to create Bogie: " + type + " -> " + capacity);
            Bogie bogie = new Bogie(type, capacity);
            System.out.println("Created Bogie: " + bogie.getType() + " -> " + bogie.getCapacity());
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}