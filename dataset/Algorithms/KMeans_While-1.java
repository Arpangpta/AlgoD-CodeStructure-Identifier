import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeansAlgorithm {
    public static void main(String[] args) {
        // Sample data points
        List<DataPoint> dataPoints = new ArrayList<>();

        // Number of clusters
        int k = 3;

        // Initialize clusters and centroids
        List<Cluster> clusters = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            Cluster cluster = new Cluster(i);
            DataPoint randomPoint = dataPoints.get(random.nextInt(dataPoints.size()));
            cluster.setCentroid(randomPoint);
            clusters.add(cluster);
        }
        
        boolean converged = false;
        // Using a While Loop
        while (!converged) {
            // Assign data points to the nearest clusters
            for (Cluster cluster : clusters) {
                cluster.clearDataPoints();
            }
            for (DataPoint dataPoint : dataPoints) {
                // Find the nearest cluster for a data point
                Cluster nearestCluster = null;
                double minDistance = Double.MAX_VALUE;
                for (Cluster cluster : clusters) {
                    double distance = dataPoint.distanceTo(cluster.getCentroid());
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestCluster = cluster;
                    }
                }
                nearestCluster.addDataPoint(dataPoint);
            }

            // Update cluster centroids and check for convergence
            boolean converged = true;
            for (Cluster cluster : clusters) {
                converged &= cluster.updateCentroid();
            }
        }

        System.out.println("Clusters using while loop: ");
        
        // Print the final clusters
        for (Cluster cluster : clusters) {
            System.out.println("Cluster " + cluster.getId() + ":");
            for (DataPoint dataPoint : cluster.getDataPoints()) {
                System.out.println(dataPoint);
            }
            System.out.println("Centroid: " + cluster.getCentroid());
        }

    }
}

class DataPoint {
    private double x, y; // Data point attributes

    public DataPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Calculate Euclidean distance to another point
    public double distanceTo(DataPoint other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Cluster {
    private int id; // Cluster identifier
    private DataPoint centroid; // Cluster centroid
    private List<DataPoint> dataPoints; // Data points assigned to the cluster

    public Cluster(int id) {
        this.id = id;
        this.dataPoints = new ArrayList<>();
    }

    // Update cluster centroid based on assigned data points
    public boolean updateCentroid() {
        // Implement centroid update logic
        return false; // Return true if converged
    }

    // Clear data points assigned to the cluster
    public void clearDataPoints() {
        dataPoints.clear();
    }

    // Add a data point to the cluster
    public void addDataPoint(DataPoint dataPoint) {
        dataPoints.add(dataPoint);
    }

    public int getId() {
        return id;
    }

    public DataPoint getCentroid() {
        return centroid;
    }

    public void setCentroid(DataPoint centroid) {
        this.centroid = centroid;
    }

    public List<DataPoint> getDataPoints() {
        return dataPoints;
    }
}