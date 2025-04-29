import java.util.HashMap;
import java.util.Map;

public class TwoAt {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 1};
        int k = 2; // Maximum number of items of the same type a person can take
        int n = arr.length;

        // Count the frequency of each item
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        // Distribute items
        Map<Integer, Integer> distributedItems = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int item = entry.getKey();
            int count = entry.getValue();

            // Each person can take at most 'k' items of the same type
            distributedItems.put(item, Math.min(count, k));
        }

        // Print the distributed items
        System.out.println("Distributed items (item -> count): " + distributedItems);
    }
}
