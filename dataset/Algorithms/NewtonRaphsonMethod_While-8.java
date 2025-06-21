public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        double number = 25.0; // The number for which we want to find the square root
        double tolerance = 1e-6; // Tolerance for convergence
        double Guess = number / 2.0; // Initial guess

        // Using a While Loop
        double temp = Guess;
        while (!(Math.abs(Math.pow(temp,2) - number) < tolerance)) {
            temp = 0.5 * (temp + number / temp);
        }
        
        System.out.println("Square root using while loop: " + temp);
    }
}
