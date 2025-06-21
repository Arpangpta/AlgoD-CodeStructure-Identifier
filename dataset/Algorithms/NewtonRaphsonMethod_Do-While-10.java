public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        double number = 25.0; // The number for which we want to find the square root
        double tolerance = 1e-6; // Tolerance for convergence
        double Guess = n / 2.0; // Initial guess

        // Using a Do-While Loop
        double num;
        do {
            num = Guess;
            Guess = 0.5 * (((num*num) + number) / num);
        } while (Math.abs((Math.pow(num,2) - number)) > tolerance);

        System.out.println("Square root using do-while loop: " + num);

    }
}
