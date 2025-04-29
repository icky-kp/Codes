import java.util.*;

public class Test {
    public static void main(String[] args) {
        int V = 5;
        Scanner sc = new Scanner(System.in);
        String edgeInput = sc.nextLine();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        String[] edges = edgeInput.split(" ");
        for (int i = 0; i < edges.length; i += 2) {
            int u = Integer.parseInt(edges[i]);
            int v = Integer.parseInt(edges[i + 1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArrayList<Integer> ans = bfsGraph(V, adj);
    }

    public static ArrayList<Integer> bfsGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ls = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ls.add(node);

            for (Integer neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return ls;
    }
}
