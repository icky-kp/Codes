import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to represent dependencies
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        System.out.println("Topological Sort Order:");
        int[] result = topoSort(V, adj);
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }

        // Example with a different graph
        // System.out.println("\n\nAnother Example:");
        // V = 4;
        // adj = new ArrayList<>();

        // for (int i = 0; i < V; i++) {
        // adj.add(new ArrayList<>());
        // }

        // adj.get(0).add(1);
        // adj.get(0).add(2);
        // adj.get(1).add(3);
        // adj.get(2).add(3);

        System.out.println("Topological Sort Order:");
        result = topoSort(V, adj);
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }
    }

    // Function to return array containing vertices in Topological order
    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        // Call the recursive helper function for all unvisited vertices
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, stack, adj);
            }
        }

        // Create result array from stack
        int[] result = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

    // DFS helper function
    private static void dfs(int node, int[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        // Mark current node as visited
        visited[node] = 1;

        // Visit all adjacent vertices
        for (Integer neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, visited, stack, adj);
            }
        }

        // After all neighbors are processed, add current node to stack
        stack.push(node);
    }
}
