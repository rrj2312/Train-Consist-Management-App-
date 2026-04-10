import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TrainApp {

    // --- UC11: Regex Validation Logic ---

    public static boolean isValidTrainId(String trainId) {
        return Pattern.matches("^TRN-\\d{4}$", trainId);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("^[A-Z]{3}-[A-Z]{2}$", cargoCode);
    }

    // --- UC12: Safety Compliance Logic ---

    public static class GoodsBogie {
        public String type;
        public String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static boolean checkSafety(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(bogie -> {
            if (bogie.type.equalsIgnoreCase("Cylindrical")) {
                return bogie.cargo.equalsIgnoreCase("Petroleum");
            }
            return true;
        });
    }

    public static void main(String[] args) {

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(b -> System.out.println(b.type + " -> " + b.cargo));

        boolean isSafe = checkSafety(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + isSafe);
        System.out.println("Train formation is " + (isSafe ? "SAFE." : "NOT SAFE."));
        System.out.println("\nUC12 safety validation completed...");
    }
}