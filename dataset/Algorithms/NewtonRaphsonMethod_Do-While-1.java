public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        double n = 25.0; // The number for which we want to find the square root
        double epsilon = 1e-6; // Tolerance for convergence
        double initialGuess = n / 2.0; // Initial guess

        // Using a Do-While Loop
        double x;
        do {
            x = initialGuess;
            initialGuess = 0.5 * (x + n / x);
        } while (Math.abs(x * x - n) > epsilon);

        System.out.println("Square root using do-while loop: " + x);

    }
}
