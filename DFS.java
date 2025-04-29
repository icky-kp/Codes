import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    private static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    private static ArrayList<Integer> dfsGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the graph
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();

        System.out.println(
                "Enter the edges as space-separated pairs (e.g., '0 1 0 2 1 3'). Enter an empty line to finish:");
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

        // Perform DFS
        ArrayList<Integer> ans = dfsGraph(V, adj);

        // Print the result
        System.out.println("DFS Traversal:");
        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}
