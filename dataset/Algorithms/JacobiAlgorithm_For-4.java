public class JacobiAlgorithm {
    public static void main(String[] args) {
        // Coefficient matrix (A)
        double[][] A = {
            {10, 2, 1},
            {1, 5, 1},
            {2, 3, 10}
        };

        // Right-hand side vector (b)
        double[] b = {7, -8, 6};

        // Initial solution (x0)
        double[] x0 = {0, 0, 0};

        int maxIterations = 10;

        // Using a For Loop (Fixed Number of Iterations)
        int n = A.length; // Number of equations

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            double[] solution = jacobiIteration(A, b, x0);

            // Update x0
            System.arraycopy(solution, 0, x0, 0, n);
        }

        System.out.println("Solution using Jacobi algorithm (fixed iterations):");
        // Print the solution
        printSolution(x0);
    }

    private static double[] jacobiIteration(double[][] A, double[] b, double[] x0) {
        int n = A.length;
        double[] solution = new double[n];

        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum = sum + A[i][j] * x0[j];
                }
            }
            solution[i] = (b[i] - sum) / A[i][i];
        }

        return solution;
    }

    private static void printSolution(double[] solution) {
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x[" + i + "] = " + solution[i]);
        }
    }
}
