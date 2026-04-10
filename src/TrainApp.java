public class TrainApp {

    // --- UC18: Linear Search Logic ---

    /**
     * Performs a linear search for a Bogie ID.
     * @param bogieIds The array of IDs to search through.
     * @param targetId The ID to find.
     * @return true if found, otherwise false.
     */
    public static boolean findBogieId(String[] bogieIds, String targetId) {
        for (String id : bogieIds) {
            // Linear search: check every element sequentially
            if (id.equals(targetId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        String[] availableIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String target = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : availableIds) {
            System.out.println(id);
        }

        boolean found = findBogieId(availableIds, target);

        if (found) {
            System.out.println("\nBogie " + target + " found in train consist.");
        } else {
            System.out.println("\nBogie " + target + " not found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}