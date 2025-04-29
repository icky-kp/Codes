import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            if (top == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1; // or throw an exception
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1; // or throw an exception
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        String[] operations = { "push", "push", "pop", "push", "push", "peek", "push", "getMin", "pop", "getMin" };
        int[][] values = { { 2 }, { 3 }, {}, { 4 }, { -1 }, {}, { 6 }, {}, {}, {} };

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "push":
                    minStack.push(values[i][0]);
                    break;
                case "pop":
                    minStack.pop();
                    break;
                case "peek":
                    System.out.println("Top element: " + minStack.peek());
                    break;
                case "getMin":
                    System.out.println("Minimum element: " + minStack.getMin());
                    break;
            }
        }
    }
}
