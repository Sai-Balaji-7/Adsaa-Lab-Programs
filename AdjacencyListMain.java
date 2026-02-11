import java.util.*;

class GraphList {

    int vertices;
    LinkedList<Integer> adjList[];

    GraphList(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    // Add edge
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Undirected graph
    }

    // Breadth First Traversal
    void BFT(int start) {
        boolean visited[] = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adj : adjList[vertex]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    // Depth First Traversal
    void DFT(int start) {
        boolean visited[] = new boolean[vertices];
        DFTUtil(start, visited);
    }

    void DFTUtil(int vertex, boolean visited[]) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjList[vertex]) {
            if (!visited[adj])
                DFTUtil(adj, visited);
        }
    }
}

public class AdjacencyListMain {
    public static void main(String[] args) {

        GraphList g = new GraphList(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.println("BFT (Adjacency List):");
        g.BFT(0);

        System.out.println("\nDFT (Adjacency List):");
        g.DFT(0);
    }
}
