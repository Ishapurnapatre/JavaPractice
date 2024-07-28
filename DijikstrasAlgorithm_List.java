import java.util.*;

class DijikstrasAlgorithm {
    private int vertices; // Number of vertices
    private LinkedList<Edge>[] adjList; // Adjacency List

    // Edge class to store vertex and weight
    static class Edge {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Constructor
    public DijikstrasAlgorithm(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    void addEdge(int v, int w, int weight) {
        adjList[v].add(new Edge(w, weight)); // Add w to v's list with the given weight
        adjList[w].add(new Edge(v, weight)); // Add v to w's list with the given weight because it's an undirected graph
    }

    // Dijkstra's algorithm to find the shortest path from a source to all other vertices
    void dijkstra(int src) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[vertices]; // Output array. dist[i] will hold the shortest distance from src to i
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Edge(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            for (Edge edge : adjList[u]) {
                int v = edge.vertex;
                int weight = edge.weight;

                // If there is a shorter path to v through u
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist);
    }

    // A utility method to print the constructed distance array
    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < vertices; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public static void main(String[] args) {
    	DijikstrasAlgorithm g = new DijikstrasAlgorithm(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.dijkstra(0);
    }
}
