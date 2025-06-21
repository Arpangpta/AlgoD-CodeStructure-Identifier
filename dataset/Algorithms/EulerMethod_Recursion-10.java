public class EulerMethod {
    public static void main(String[] args) {
        double size = 0.5; // Step size
        double x0 = 0.0; // Initial x value
        double y0 = 1.0; // Initial y value

        // Using Recursion
        double resultRecursion = solveODEUsingRecursion(size, x0, y0, 7.0);
        System.out.println("Result using recursion: " + resultRecursion);
    }

    // Method 4: Euler Method with Recursion
    private static double solveODEUsingRecursion(double size, double initial_x, double initial_y, double max) {
        if (initial_x >= max) {
            return initial_y;
        }
        initial_y = initial_y + size * (Math.pow(initial_x, 2) - initial_y);
        initial_x = initial_x + size;
        return solveODEUsingRecursion(size, initial_x, initial_y, max);
    }
}