import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        int vertices = 4; // Number of vertices in the graph
        int start = 0; // Starting vertex

        int[][] graph = {
            // An adjacency matrix representing the weighted graph
            {0, 1, 3, 0},
            {1, 0, 2, 0},
            {3, 2, 0, 4},
            {0, 0, 4, 0}
        };

        // Method 1: Dijkstra Algorithm with Priority Queue
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(vertices, Comparator.comparingInt(i -> distances[i]));
        priorityQueue.add(start);

        dijkstra(graph, start, vertices, distances, visited, priorityQueue);

        printShortestDistances(start, vertices, distances);
    }

    private static void dijkstra(int[][] graph, int start, int vertices, int[] distances, boolean[] visited, PriorityQueue<Integer> priorityQueue) {
        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll();
            visited[currentVertex] = true;

            for (int nextVertex = 0; nextVertex < vertices; nextVertex++) {
                if (!visited[nextVertex] && graph[currentVertex][nextVertex] != 0) {
                    int newDistance = distances[currentVertex] + graph[currentVertex][nextVertex];
                    if (newDistance < distances[nextVertex]) {
                        distances[nextVertex] = newDistance;
                        priorityQueue.add(nextVertex);
                    }
                }
            }
        }
    }

    private static void printShortestDistances(int start, int vertices, int[] distances) {
        System.out.println("Shortest distances from vertex " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}
