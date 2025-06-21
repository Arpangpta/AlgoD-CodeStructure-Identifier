import java.util.HashMap;
import java.util.Map;

public class DijkstraWithoutPriorityQueue {

    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();

        initialize(graph, distances, predecessors, start);

        while (!graph.isEmpty()) {
            String currentNode = findMinDistanceNode(graph, distances);
            updateDistances(graph.get(currentNode), distances, predecessors, currentNode);
            graph.remove(currentNode);
        }

        return distances;
    }

    private static void initialize(Map<String, Map<String, Integer>> graph, Map<String, Integer> distances, Map<String, String> predecessors, String start) {
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
            predecessors.put(node, null);
        }
        distances.put(start, 0);
    }

    private static String findMinDistanceNode(Map<String, Map<String, Integer>> graph, Map<String, Integer> distances) {
        String currentNode = null;
        int minDistance = Integer.MAX_VALUE;

        for (String node : graph.keySet()) {
            int currentDistance = distances.get(node);
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                currentNode = node;
            }
        }

        return currentNode;
    }

    private static void updateDistances(Map<String, Integer> neighbors, Map<String, Integer> distances, Map<String, String> predecessors, String currentNode) {
        for (Map.Entry<String, Integer> entry : neighbors.entrySet()) {
            String neighbor = entry.getKey();
            int weight = entry.getValue();
            int potentialDistance = distances.get(currentNode) + weight;

            if (potentialDistance < distances.get(neighbor)) {
                distances.put(neighbor, potentialDistance);
                predecessors.put(neighbor, currentNode);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        // Populate the graph with vertices and edges

        String startNode = "A";
        Map<String, Integer> result = dijkstra(graph, startNode);

        // Print the results
        System.out.println("Shortest distances from " + startNode + ": " + result);
    }
}
