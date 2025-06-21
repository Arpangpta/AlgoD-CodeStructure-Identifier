public class JacobiAlgorithm {
    public static void main(String[] args) {
        double[][] coefficientMatrix = {
            {10, 2, 1},
            {1, 5, 1},
            {2, 3, 10}
        };

        double[] rightHandSide = {7, -8, 6};
        double[] initialSolution = {0, 0, 0};
        double epsilon = 0.0001;

        int numberOfEquations = coefficientMatrix.length;
        double[] solution = new double[numberOfEquations];

        while (!hasConverged(initialSolution, solution, epsilon)) {
            performJacobiIteration(coefficientMatrix, rightHandSide, initialSolution, solution);
            updateSolution(initialSolution, solution, numberOfEquations);
        }

        System.out.println("Solution using Jacobi algorithm (while loop):");
        printSolution(solution);
    }

    private static void performJacobiIteration(double[][] coefficientMatrix, double[] rightHandSide, double[] currentSolution, double[] updatedSolution) {
        int numberOfEquations = coefficientMatrix.length;

        for (int i = 0; i < numberOfEquations; i++) {
            double sum = 0;
            for (int j = 0; j < numberOfEquations; j++) {
                if (i != j) {
                    sum += coefficientMatrix[i][j] * currentSolution[j];
                }
            }
            updatedSolution[i] = (rightHandSide[i] - sum) / coefficientMatrix[i][i];
        }
    }

    private static void updateSolution(double[] currentSolution, double[] updatedSolution, int numberOfEquations) {
        System.arraycopy(updatedSolution, 0, currentSolution, 0, numberOfEquations);
    }

    private static boolean hasConverged(double[] currentSolution, double[] updatedSolution, double epsilon) {
        int numberOfEquations = currentSolution.length;

        for (int i = 0; i < numberOfEquations; i++) {
            if (Math.abs(updatedSolution[i] - currentSolution[i]) > epsilon) {
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
