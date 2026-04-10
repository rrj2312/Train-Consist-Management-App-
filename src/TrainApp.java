import java.util.ArrayList;
import java.util.List;

// UC15 Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

public class TrainApp {

    public static class Bogie {
        private String type;
        private String cargo = "None";

        public Bogie(String type) {
            this.type = type;
        }

        public void assignCargo(String newCargo) {
            // Constraint: Petroleum can ONLY be assigned to Cylindrical bogies
            if (newCargo.equalsIgnoreCase("Petroleum") && !this.type.equalsIgnoreCase("Cylindrical")) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }
            this.cargo = newCargo;
            System.out.println("Cargo assigned successfully -> " + this.cargo);
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }
    }

    public static void main(String[] args) {

        Bogie b1 = new Bogie("Cylindrical");
        Bogie b2 = new Bogie("Rectangular");

        // Process Bogie 1
        try {
            b1.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo validation completed for " + b1.getType() + " bogie\n");
        }

        // Process Bogie 2 (Will fail)
        try {
            b2.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo validation completed for " + b2.getType() + " bogie");
        }

        System.out.println("\nUC15 runtime handling completed...");
    }
}