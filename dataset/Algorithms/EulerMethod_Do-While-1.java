public class EulerMethod {
    public static void main(String[] args) {
        double h = 0.2; // Step size
        double x = 0.0; // Initial x value
        double y = 1.0; // Initial y value

        // Using a Do-While Loop
        do {
            y += h * (x * x - y);
            x += h;
        } while (x < 2.0);
        System.out.println("Result using do-while loop: " + y);
    }
}