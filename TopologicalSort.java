import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    private int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void createEdge(int u, int v) {
        this.adjacencyList.get(u).add(v);
    }

    public void topologicalSort() {
        int[] totalIndegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j : adjacencyList.get(i)) {
                totalIndegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (totalIndegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedNodes = 0;
        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int i : adjacencyList.get(u)) {
                totalIndegree[i]--;

                if (totalIndegree[i] == 0) {
                    queue.add(i);
                }
            }
            visitedNodes++;
        }

        if (visitedNodes != vertices) {
            System.out.println("The graph contains a cycle. Topological sorting is not possible.");
        } else {
            System.out.println("Topological Sort: " + order);
        }
    }
}

public class TopologicalSort {
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        Graph graph = new Graph(6);

        // Add edges to the graph
        graph.createEdge(5, 2);
        graph.createEdge(5, 0);
        graph.createEdge(4, 0);
        graph.createEdge(4, 1);
        graph.createEdge(2, 3);
        graph.createEdge(3, 1);

        // Perform topological sort
        graph.topologicalSort();
    }
}
