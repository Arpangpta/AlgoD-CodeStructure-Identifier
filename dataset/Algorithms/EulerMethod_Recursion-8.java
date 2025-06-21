public class EulerMethod {
    public static void main(String[] args) {
        double size = 0.5; // Step size
        double x0 = 0.0; // Initial x value
        double y0 = 1.0; // Initial y value

        // Using Recursion
        double resultRecursion = solveODEUsingRecursion(size, x0, y0, 2.0);
        System.out.println("Result using recursion: " + resultRecursion);
    }

    // Method 4: Euler Method with Recursion
    private static double solveODEUsingRecursion(double h, double x, double y, double xMax) {
        if (x >= xMax) {
            return y;
        }
        y += h * (Math.pow(x, 2) - y);
        x = x + h;
        return solveODEUsingRecursion(h, x, y, xMax);
    }
}
