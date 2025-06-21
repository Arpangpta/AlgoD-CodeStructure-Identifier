import java.util.HashMap;
import java.util.Map;

public class DijkstraWithoutPriorityQueue {

    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();

        // Initialize distances and predecessors
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
            predecessors.put(node, null);
        }
        distances.put(start, 0);

        // Main loop
        while (!graph.isEmpty()) {
            // Find the node with the smallest tentative distance
            String currentNode = null;
            int minDistance = Integer.MAX_VALUE;

            for (String node : graph.keySet()) {
                int currentDistance = distances.get(node);
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                    currentNode = node;
                }
            }

            // Update distances for neighbors of the current node
            for (Map.Entry<String, Integer> entry : graph.get(currentNode).entrySet()) {
                String neighbor = entry.getKey();
                int weight = entry.getValue();
                int potentialDistance = distances.get(currentNode) + weight;

                if (potentialDistance < distances.get(neighbor)) {
                    distances.put(neighbor, potentialDistance);
                    predecessors.put(neighbor, currentNode);
                }
            }

            // Remove the current node from the graph
            graph.remove(currentNode);
        }

        return distances;
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
