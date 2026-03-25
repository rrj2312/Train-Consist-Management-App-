import java.util.LinkedList;

public class TrainApp {
    public static void main(String[] args) {
        // Header
        System.out.println(" UC4 - Maintain Ordered Bogie Consist");
        System.out.println();

        LinkedList<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);
        System.out.println();

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        trainConsist.add(2, "Pantry Car");
        System.out.println(trainConsist);
        System.out.println();

        System.out.println("After Removing First and Last Bogie:");
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println(trainConsist);
        System.out.println();

        System.out.println("UC4 ordered consist operations completed...");
    }
}
