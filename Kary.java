import java.util.ArrayList;
import java.util.Scanner;

public class Kary {
    private static int n; // Number of children per node (k-ary heap)
    private static ArrayList<Integer> arl = new ArrayList<>();

    public static int getMax() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arl.get(0);
    }

    public static boolean isEmpty() {
        return (arl.size() == 0);
    }

    public static void insert(int value) {
        arl.add(value);
        int childrenIndex = arl.size() - 1;
        int parentIndex = (childrenIndex - 1) / n;
        while (parentIndex >= 0 && arl.get(childrenIndex) > arl.get(parentIndex)) {
            int temp = arl.get(childrenIndex);
            arl.set(childrenIndex, arl.get(parentIndex));
            arl.set(parentIndex, temp);

            childrenIndex = parentIndex;
            parentIndex = (childrenIndex - 1) / n;
        }
    }

    public static void removeMax() {
        if (isEmpty()) {
            System.out.println("Heap is empty. Cannot remove the maximum element.");
            return;
        }

        arl.set(0, arl.get(arl.size() - 1));
        arl.remove(arl.size() - 1);

        int parentIndex = 0;

        while (true) {
            int largestValueIndex = parentIndex;

            for (int i = n * parentIndex + 1; i <= (n * parentIndex + n) && i < arl.size(); i++) {
                if (arl.get(largestValueIndex) < arl.get(i)) {
                    largestValueIndex = i;
                }
            }

            if (largestValueIndex == parentIndex) {
                break;
            } else {
                int temp = arl.get(parentIndex);
                arl.set(parentIndex, arl.get(largestValueIndex));
                arl.set(largestValueIndex, temp);

                parentIndex = largestValueIndex;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of k (number of children per node)
        System.out.println("Enter the value of k (number of children per node):");
        n = scanner.nextInt();

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
        System.out.println("Heap after insertion: " + arl);
        System.out.println("Get Top element: " + getMax());

        // Remove the maximum element
        removeMax();
        System.out.println("Heap after removing the maximum element: " + arl);
        System.out.println("The maximum element in the heap is now: " + getMax());

        scanner.close();
    }
}
