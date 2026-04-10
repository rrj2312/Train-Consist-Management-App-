import java.util.Arrays;

public class TrainApp {

    // Existing methods (UC11-UC15) would be above...

    // --- UC16: Manual Sorting (Bubble Sort) ---

    public static class PassengerBogie {
        String type;
        int capacity;

        public PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void bubbleSortByCapacity(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Manual Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        printArray(capacities);

        bubbleSortByCapacity(capacities);

        System.out.println("\nSorted Capacities (Ascending):");
        printArray(capacities);

        System.out.println("\nUC16 sorting completed...");
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}