import java.util.LinkedHashSet;
import java.util.Set;

public class TrainApp {
    public static void main(String[] args) {
        Set<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        trainFormation.add("Sleeper");

        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println();

        System.out.println("Final Train Formation:");
        System.out.println(trainFormation);

        System.out.println();
        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println();
        System.out.println("UC5 formation setup completed...");
    }
}
