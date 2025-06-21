import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        int numVertices = 5; // Number of vertices in the graph
        int startVertex = 1; // Starting vertex

        int[][] graph = {
            // An adjacency matrix representing the weighted graph
            {0, 2, 0, 4, 0},
            {2, 0, 1, 5, 0},
            {0, 1, 0, 0, 3},
            {4, 5, 0, 0, 1},
            {0, 0, 3, 1, 0}
        };

        // Dijkstra Algorithm with Priority Queue
        int[] shortestDistances = new int[numVertices];
        boolean[] visitedVertices = new boolean[numVertices];

        Arrays.fill(shortestDistances, Integer.MAX_VALUE);
        shortestDistances[startVertex] = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(numVertices, Comparator.comparingInt(i -> shortestDistances[i]));
        priorityQueue.add(startVertex);

        runDijkstra(graph, startVertex, numVertices, shortestDistances, visitedVertices, priorityQueue);

        printShortestDistances(startVertex, numVertices, shortestDistances);
    }

    private static void runDijkstra(int[][] graph, int start, int numVertices, int[] distances, boolean[] visited, PriorityQueue<Integer> priorityQueue) {
        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll();
            visited[currentVertex] = true;

            for (int nextVertex = 0; nextVertex < numVertices; nextVertex++) {
                if (visited[nextVertex] || graph[currentVertex][nextVertex] == 0) {
                    continue;
                }

                int newDistance = distances[currentVertex] + graph[currentVertex][nextVertex];
                if (newDistance < distances[nextVertex]) {
                    distances[nextVertex] = newDistance;
                    priorityQueue.add(nextVertex);
                }
            }
        }
    }

    private static void printShortestDistances(int start, int numVertices, int[] distances) {
        System.out.println("Shortest distances from vertex " + start + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}
