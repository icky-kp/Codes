public class Segregate {
    public static int[] segregateEvenOdd(int[] arr) {
        int[] result = new int[arr.length];
        int evenIndex = 0;
        int oddIndex = 0;

        // First pass: Count even and odd numbers
        for (int num : arr) {
            if (num % 2 == 0) {
                evenIndex++;
            }
        }

        oddIndex = evenIndex; // Set oddIndex to start after even numbers
        evenIndex = 0; // Reset evenIndex for the second pass

        // Second pass: Place numbers in the result array
        for (int num : arr) {
            if (num % 2 == 0) {
                result[evenIndex++] = num;
            } else {
                result[oddIndex++] = num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4, 7, 6, 9, 10 };

        System.out.println("Original array:");
        printArray(arr);

        int[] segregated = segregateEvenOdd(arr);

        System.out.println("Array after segregation:");
        printArray(segregated);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
