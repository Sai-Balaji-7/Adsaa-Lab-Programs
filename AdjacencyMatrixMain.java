import java.util.*;

class GraphMatrix {

    int vertices;
    int adjMatrix[][];
    
    GraphMatrix(int v) {
        vertices = v;
        adjMatrix = new int[v][v];
    }

    // Add edge
    void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // Undirected graph
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

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
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

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                DFTUtil(i, visited);
            }
        }
    }
}

public class AdjacencyMatrixMain {
    public static void main(String[] args) {

        GraphMatrix g = new GraphMatrix(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.println("BFT (Adjacency Matrix):");
        g.BFT(0);

        System.out.println("\nDFT (Adjacency Matrix):");
        g.DFT(0);
    }
}
