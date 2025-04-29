import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static ArrayList<Integer> bfsGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V]; // Visited array to keep track of visited nodes
        ArrayList<Integer> ls = new ArrayList<>(); // List to store BFS traversal result
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Start BFS from node 0 (assuming 0-based indexing)
        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ls.add(node);

            // Traverse all adjacent nodes
            for (Integer neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    queue.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }

        return ls;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the graph
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();

        System.out.println("Enter the edges in the format '1-2', '2-3', etc. Enter an empty line to finish:");
        scanner.nextLine(); // Consume the newline character

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Parse the edges
        while (true) {
            String edgeInput = scanner.nextLine().trim();
            if (edgeInput.isEmpty()) {
                break; // Stop when an empty line is entered
            }

            String[] edge = edgeInput.split("-");
            int u = Integer.parseInt(edge[0]) - 1; // Convert to 0-based indexing
            int v = Integer.parseInt(edge[1]) - 1; // Convert to 0-based indexing
            adj.get(u).add(v);
            adj.get(v).add(u); // Assuming an undirected graph
        }

        // Perform BFS
        ArrayList<Integer> ans = bfsGraph(V, adj);

        // Print the result
        System.out.println("BFS Traversal:");
        for (int node : ans) {
            System.out.print((node + 1) + " "); // Convert back to 1-based indexing for output
        }
    }
}
