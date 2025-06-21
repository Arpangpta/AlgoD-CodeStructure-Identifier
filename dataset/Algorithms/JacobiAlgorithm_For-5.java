public class JacobiAlgorithm {
    public static void main(String[] args) {
        // Coefficient matrix (A)
        double[][] A = {
            {5, 1, 2},
            {2, 8, 2},
            {1, 3, 6}
        };

        // Right-hand side vector (b)
        double[] b = {4, -9, 5};

        // Initial solution (x0)
        double[] x0 = {1, 1, 1};

        int maxIterations = 15;

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
                    sum += A[i][j] * x0[j];
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
