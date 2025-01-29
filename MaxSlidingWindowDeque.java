import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class MaxSlidingWindowDequeue {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements as they are no longer candidates for
            // maximum
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // If we have a valid window, add to result
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Window size: " + k);

        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Maximum sliding window: " + Arrays.toString(result));
    }

}
