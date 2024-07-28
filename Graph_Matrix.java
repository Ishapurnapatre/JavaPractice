import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private int[][] adjMatrix; // Adjacency Matrix

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Method to add an edge to the graph
    void addEdge(int v, int w) {
        adjMatrix[v][w] = 1; // Add w to v's list
        adjMatrix[w][v] = 1; // Add v to w's list because it's an undirected graph
    }

    // BFS traversal from a given source
    void bfs(int source) {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[source][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // DFS traversal from a given source
    void dfsUtil(int source, boolean visited[]) {
        visited[source] = true;
        System.out.print(source + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[source][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    void dfs(int source) {
        boolean visited[] = new boolean[vertices];
        dfsUtil(source, visited);
    }

    public static void main(String args[]) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.println("BFS starting from vertex 0:");
        g.bfs(0);

        System.out.println("\nDFS starting from vertex 0:");
        g.dfs(0);
    }
}
