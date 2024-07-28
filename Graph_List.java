import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency List

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new LinkedList<>();
    }

    // Method to add an edge to the graph
    void addEdge(int v, int w) {
        adjList[v].add(w); // Add w to v's list
        adjList[w].add(v); // Add v to w's list because it's an undirected graph
    }

    // BFS traversal from a given source
    void bfs(int source) {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            source = queue.poll();
            System.out.print(source + " ");

            Iterator<Integer> i = adjList[source].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // DFS traversal from a given source
    void dfsUtil(int source, boolean visited[]) {
        visited[source] = true;
        System.out.print(source + " ");

        Iterator<Integer> i = adjList[source].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                dfsUtil(n, visited);
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
