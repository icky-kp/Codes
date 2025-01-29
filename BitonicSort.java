public class BitonicSort {

    public static void compAndSwap(int a[], int i, int j, int dir) {
        if (dir == (a[i] > a[j] ? 1 : 0)) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void bitonicMerge(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                compAndSwap(a, i, i + k, dir);
            }
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    public static void bitonicSort(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(a, low, k, 1); // Sort in ascending order
            bitonicSort(a, low + k, k, 0); // Sort in descending order
            bitonicMerge(a, low, cnt, dir); // Merge the whole sequence in ascending order
        }
    }

    public static void sort(int a[], int N, int up) {
        bitonicSort(a, 0, N, up);
    }

    public static void main(String[] args) {
        int a[] = { 3, 7, 4, 8, 6, 2, 1, 5 };
        int N = a.length;
        int up = 1; // 1 means sort in ascending order

        sort(a, N, up);

        System.out.println("Sorted array: ");
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
