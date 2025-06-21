public class EulerMethod {
    public static void main(String[] args) {
        double h = 0.2; // Step size
        double x0 = 0.0; // Initial x value
        double y0 = 1.0; // Initial y value

        // Using Recursion
        double resultRecursion = solveODEUsingRecursion(h, x0, y0, 2.0);
        System.out.println("Result using recursion: " + resultRecursion);
    }

    // Method 4: Euler Method with Recursion
    private static double solveODEUsingRecursion(double h, double x, double y, double xMax) {
        if (x >= xMax) {
            return y;
        }
        y += h * (x * x - y);
        x += h;
        return solveODEUsingRecursion(h, x, y, xMax);
    }
}
