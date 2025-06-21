public class EulerMethod {
    public static void main(String[] args) {
        double h = 0.2; // Step size
        double x = 0.0; // Initial x value
        double y = 1.0; // Initial y value

        // Using a For Loop
        int maxIterations = 10; // Maximum number of iterations
        for (int i = 0; i < maxIterations; i++) {
            y += h * (x * x - y);
            x += h;
        }
        System.out.println("Result using for loop: " + y);
    }
}