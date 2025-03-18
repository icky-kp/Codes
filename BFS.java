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

        System.out.println(
                "Enter the edges as space-separated pairs (e.g., '0 1 0 2 1 3'). Enter an empty line to finish:");
        scanner.nextLine(); // Consume the newline character
        String edgeInput = scanner.nextLine();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Parse the edges
        String[] edges = edgeInput.split(" ");
        for (int i = 0; i < edges.length; i += 2) {
            int u = Integer.parseInt(edges[i]);
            int v = Integer.parseInt(edges[i + 1]);
            adj.get(u).add(v);
            adj.get(v).add(u); // Assuming an undirected graph
        }

        // Perform BFS
        ArrayList<Integer> ans = bfsGraph(V, adj);

        // Print the result
        System.out.println("BFS Traversal:");
        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}
