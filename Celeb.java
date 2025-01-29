import java.util.Stack;

public class Celeb {
    // Function to check if person `a` knows person `b`
    static boolean knows(int a, int b, int[][] matrix) {
        return matrix[a][b] == 1;
    }

    // Function to find the celebrity
    static int findCelebrity(int n, int[][] matrix) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all people onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: Find a potential celebrity
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(a, b, matrix)) {
                // If `a` knows `b`, `a` cannot be a celebrity
                stack.push(b);
            } else {
                // If `a` does not know `b`, `b` cannot be a celebrity
                stack.push(a);
            }
        }

        // Step 3: Verify the potential celebrity
        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // A celebrity should not know anyone, and everyone should know the celebrity
                if (knows(candidate, i, matrix) || !knows(i, candidate, matrix)) {
                    return -1; // No celebrity found
                }
            }
        }

        return candidate; // Return the celebrity index
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 1, 1, 0 }
        };

        int n = matrix.length;
        int result = findCelebrity(n, matrix);

        if (result == -1) {
            System.out.println("There is no celebrity in the party.");
        } else {
            System.out.println("Celebrity ID: " + result);
        }
    }
}
