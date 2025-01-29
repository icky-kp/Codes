import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();

        // First day's span is always 1
        spans[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Calculate span
            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push this element to stack
            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        int[] spans = calculateSpan(prices);

        System.out.println("Stock spans:");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
