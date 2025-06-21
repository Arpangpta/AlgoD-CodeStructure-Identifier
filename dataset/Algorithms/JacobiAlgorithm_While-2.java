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

        double epsilon = 0.0001;

        // Using a While Loop
        int n = A.length; // Number of equations
        double[] solution = new double[n];

        while (!hasConverged(x0, solution, epsilon)) {
            performJacobiIteration(A, b, x0, solution);
            updateSolution(x0, solution, n);
        }

        System.out.println("Solution using while loop:");
        // Print the solution
        printSolution(solution);
    }

    private static void performJacobiIteration(double[][] A, double[] b, double[] x0, double[] solution) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum += A[i][j] * x0[j];
                }
            }
            solution[i] = (b[i] - sum) / A[i][i];
        }
    }

    private static void updateSolution(double[] x0, double[] solution, int n) {
        System.arraycopy(solution, 0, x0, 0, n);
    }

    private static boolean hasConverged(double[] x0, double[] solution, double epsilon) {
        int n = x0.length;
        for (int i = 0; i < n; i++) {
            if (Math.abs(solution[i] - x0[i]) > epsilon) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution(double[] solution) {
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x[" + i + "] = " + solution[i]);
        }
    }
}
