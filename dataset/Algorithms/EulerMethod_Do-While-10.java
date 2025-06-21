public class EulerMethod {
    public static void main(String[] args) {
        double size = 0.2; // Step size
        double x = 0.0; // Initial x value
        double y = 1.0; // Initial y value
        double max = 5.0;
        // Using a Do-While Loop
        do {
            y = y + size * (Math.pow(x, 2) - y);
            x = x + size;
        } while (x < max);
        System.out.println("Result using do-while loop: " + y);
    }
}