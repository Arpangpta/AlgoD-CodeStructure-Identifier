public class EulerMethod {
    public static void main(String[] args) {
        double size = 0.5; // Step size
        double x = 0.0; // Initial x value
        double y = 1.0; // Initial y value

        // Using a For Loop
        int maxIterations = 10; // Maximum number of iterations
        for (int i = 0; i < maxIterations; i++) {
            y += size * (x * x - y);
            x = x + size;
        }
        System.out.println("Result using for loop: " + y);
    }
}