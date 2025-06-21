public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        double n = 25.0; // The number for which we want to find the square root
        double epsilon = 1e-6; // Tolerance for convergence
        double initialGuess = n / 2.0; // Initial guess

        // Using a While Loop
        double x = initialGuess;
        while (Math.abs(x * x - n) > epsilon) {
            x = 0.5 * (x + n / x);
        }
        
        System.out.println("Square root using while loop: " + x);
    }
}
