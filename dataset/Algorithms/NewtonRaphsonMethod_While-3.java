public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        double number = 25.0; // The number for which we want to find the square root
        double tolerance = 1e-6; // Tolerance for convergence
        double initialGuess = number / 2.0; // Initial guess

        // Using a While Loop
        double x = initialGuess;
        while (Math.abs(x * x - number) > tolerance) {
            x = 0.5 * (x + number / x);
        }
        
        System.out.println("Square root using while loop: " + x);
    }
}
