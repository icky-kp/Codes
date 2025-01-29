public class MaxSlidingWindow {
    static void printKMax(int arr[], int N, int K) {

        for (int i = 0; i <= N - K; i++) {

            int max;
            max = arr[i];

            for (int j = 1; j < K; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = { 3, 1, 1, 2, 1, 4 };
        int K = 3;
        printKMax(arr, arr.length, K);
    }
}
