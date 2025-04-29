import java.util.ArrayList;
import java.util.Scanner;

public class KaryHeap {
    private static int k; // Number of children per node (k-ary heap)
    private static ArrayList<Integer> heap = new ArrayList<>();

    // Get the maximum element (root of the heap)
    public static int getMax() {
        return heap.isEmpty() ? Integer.MIN_VALUE : heap.get(0);
    }

    // Insert a value into the heap
    public static void insert(int value) {
        heap.add(value); // Add the value at the end
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / k;

        // Bubble up to maintain the max-heap property
        while (childIndex > 0 && heap.get(childIndex) > heap.get(parentIndex)) {
            // Swap child and parent
            int temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            // Update indices
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / k;
        }
    }

    // Remove the maximum element (root of the heap)
    public static void removeMax() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty. Cannot remove the maximum element.");
            return;
        }

        // Replace the root with the last element and remove the last element
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int parentIndex = 0;

        // Bubble down to maintain the max-heap property
        while (true) {
            int largestIndex = parentIndex;

            // Check all k children of the current parent
            for (int i = 1; i <= k; i++) {
                int childIndex = k * parentIndex + i;
                if (childIndex < heap.size() && heap.get(childIndex) > heap.get(largestIndex)) {
                    largestIndex = childIndex;
                }
            }

            // If the parent is already larger than all its children, stop
            if (largestIndex == parentIndex) {
                break;
            }

            // Swap parent with the largest child
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(largestIndex));
            heap.set(largestIndex, temp);

            // Update the parent index
            parentIndex = largestIndex;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of k (number of children per node)
        System.out.println("Enter the value of k (number of children per node):");
        k = scanner.nextInt();

        // Input the number of elements to insert into the heap
        System.out.println("Enter the number of elements to insert into the heap:");
        int numElements = scanner.nextInt();

        // Input the elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < numElements; i++) {
            int value = scanner.nextInt();
            insert(value);
        }

        // Display the heap and perform operations
        System.out.println("Heap after insertion: " + heap);
        System.out.println("Get Top element: " + getMax());

        // Remove the maximum element
        removeMax();
        System.out.println("Heap after removing the maximum element: " + heap);
        System.out.println("The maximum element in the heap is now: " + getMax());

        scanner.close();
    }
}
