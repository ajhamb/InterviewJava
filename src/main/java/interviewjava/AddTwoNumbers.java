package interviewjava;

import java.util.Scanner;

/**
 * Simple program to add two numbers.
 *
 * Usage:
 * 1) Provide two numbers as command-line arguments:
 *    java interviewjava.AddTwoNumbers 3 5
 *
 * 2) Or run without args and enter two numbers when prompted (space or newline separated):
 *    java interviewjava.AddTwoNumbers
 *    Enter first number: 3
 *    Enter second number: 5
 */
public class AddTwoNumbers {
    /**
     * Add two numbers and return the result as a double.
     * This method is exposed so unit tests can call it directly.
     */
    public static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        boolean fromArgs = false;

        if (args.length >= 2) {
            try {
                a = Double.parseDouble(args[0]);
                b = Double.parseDouble(args[1]);
                fromArgs = true;
            } catch (NumberFormatException e) {
                System.err.println("Error: command-line arguments must be numbers.");
                System.err.println("Usage: java interviewjava.AddTwoNumbers <num1> <num2>");
                System.exit(2);
            }
        }

        if (!fromArgs) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Enter first number: ");
                a = Double.parseDouble(sc.next());
                System.out.print("Enter second number: ");
                b = Double.parseDouble(sc.next());
            } catch (NumberFormatException e) {
                System.err.println("Error: input must be numeric.");
                System.exit(2);
            } catch (Exception e) {
                System.err.println("Error reading input: " + e.getMessage());
                System.exit(3);
            } finally {
                sc.close();
            }
        }

        double sum = add(a, b);

        // If both inputs were integral values, print without decimal point where appropriate
        if (isWholeNumber(a) && isWholeNumber(b)) {
            long la = (long) a;
            long lb = (long) b;
            long lsum = la + lb;
            System.out.println(lsum);
        } else {
            System.out.println(sum);
        }
    }

    private static boolean isWholeNumber(double d) {
        return Math.floor(d) == d && !Double.isInfinite(d);
    }
}
