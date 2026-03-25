import java.util.HashMap;
import java.util.Map;

public class TrainApp {
    public static void main(String[] args) {
        Map<String, Integer> bogieCapacities = new HashMap<>();

        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("Cargo", 120);
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);

        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println();

        System.out.println("Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println();
        System.out.println("UC6 bogie-capacity mapping completed...");
    }
}
