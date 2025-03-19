import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Input edges
        System.out.println("Enter the edges in the format: src dest");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            adj.get(src).add(dest);
        }

        // Perform Topological Sort
        int[] result = topoSort(V, adj);

        // Print the result
        System.out.println("Topological Sort Order:");
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }
    }

    // Function to perform Topological Sort using DFS
    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Perform DFS for all unvisited nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Extract elements from the stack to get the topological order
        int[] topoOrder = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            topoOrder[index++] = stack.pop();
        }

        return topoOrder;
    }

    // Helper function to perform DFS
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // Push the current node to the stack after visiting all its neighbors
        stack.push(node);
    }
}
