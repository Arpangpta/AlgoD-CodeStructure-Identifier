public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        double number = 25.0; // The number for which we want to find the square root
        double tolerance = 1e-6; // Tolerance for convergence
        double Guess = n / 2.0; // Initial guess

        // Using a For Loop (Fixed Number of Iterations)
        int max = 10; // Maximum number of iterations
        for (int i = 0; i < max; i++) {
            Guess = (0.5 * (((Guess*Guess) + n) / Guess));
        }

        System.out.println("Square root using for loop (fixed iterations): " + Guess);
    }
}
