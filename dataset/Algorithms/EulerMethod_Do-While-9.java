public class EulerMethod {
    public static void main(String[] args) {
        double size = 0.2; // Step size
        double x = 0.0; // Initial x value
        double y = 1.0; // Initial y value

        // Using a Do-While Loop
        do {
            y = y + size * (Math.pow(x, 2) - y);
            x = x + size;
        } while (x < 2.0);
        System.out.println("Result using do-while loop: " + y);
    }
}