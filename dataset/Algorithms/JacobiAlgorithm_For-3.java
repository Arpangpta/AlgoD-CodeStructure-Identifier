public class JacobiAlgorithm {
    public static void main(String[] args) {
        // Coefficient matrix (A)
        double[][] coefficientMatrix = {
                {10, 2, 1},
                {1, 5, 1},
                {2, 3, 10}
        };

        // Right-hand side vector (b)
        double[] rightHandSide = {7, -8, 6};

        // Initial solution (x0)
        double[] initialSolution = {0, 0, 0};

        int maxIterations = 10;

        // Using a For Loop (Fixed Number of Iterations)
        int numberOfEquations = coefficientMatrix.length;

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            double[] updatedSolution = performJacobiIteration(coefficientMatrix, rightHandSide, initialSolution);

            // Update x0
            System.arraycopy(updatedSolution, 0, initialSolution, 0, numberOfEquations);
        }

        System.out.println("Solution using Jacobi algorithm (fixed iterations):");
        // Print the solution
        printSolution(initialSolution);
    }

    private static double[] performJacobiIteration(double[][] coefficientMatrix, double[] rightHandSide, double[] currentSolution) {
        int numberOfEquations = coefficientMatrix.length;
        double[] updatedSolution = new double[numberOfEquations];

        for (int i = 0; i < numberOfEquations; i++) {
            double sum = 0;
            for (int j = 0; j < numberOfEquations; j++) {
                if (i != j) {
                    sum += coefficientMatrix[i][j] * currentSolution[j];
                }
            }
            updatedSolution[i] = (rightHandSide[i] - sum) / coefficientMatrix[i][i];
        }

        return updatedSolution;
    }

    private static void printSolution(double[] solution) {
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x[" + i + "] = " + solution[i]);
        }
    }
}
