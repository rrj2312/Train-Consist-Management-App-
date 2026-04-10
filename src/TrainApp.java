import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainApp {


    public static class Bogie {
        private String id;
        private int capacity;

        public Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }
        public int getCapacity() { return capacity; }
    }

    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) filtered.add(b);
        }
        return filtered;
    }

    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Bogie> trainConsist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            trainConsist.add(new Bogie("B" + i, (int) (Math.random() * 100)));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(trainConsist);
        long durationLoop = System.nanoTime() - startLoop;

        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(trainConsist);
        long durationStream = System.nanoTime() - startStream;

        System.out.println("Loop Execution Time (ns): " + durationLoop);
        System.out.println("Stream Execution Time (ns): " + durationStream);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}