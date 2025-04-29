import java.util.ArrayList;
import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 11, 40, 5, 3, 1));
        System.out.println(lbs(arr));
    }

    static int lbs(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n < 3) {
            return 0;
        }

        // Initialize left and right lists
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            left.add(1);
            right.add(1);
        }

        // Compute LIS (Longest Increasing Subsequence) for each element
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(i) > arr.get(j)) {
                    left.set(i, Math.max(left.get(i), left.get(j) + 1));
                }
            }
        }

        // Compute LDS (Longest Decreasing Subsequence) for each element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr.get(i) > arr.get(j)) {
                    right.set(i, Math.max(right.get(i), right.get(j) + 1));
                }
            }
        }

        // Find the maximum length of the bitonic subsequence
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            if (left.get(i) > 1 && right.get(i) > 1) {
                maxlen = Math.max(maxlen, left.get(i) + right.get(i) - 1);
            }
        }

        return maxlen < 3 ? 0 : maxlen;
    }
}
