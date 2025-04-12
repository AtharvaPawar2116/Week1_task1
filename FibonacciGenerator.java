import java.util.Scanner;

public class FibonacciGenerator {
    public static void generateUpToTerm(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series up to " + n + " terms: ");
        for (int i = 1; i <= n; ++i) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void generateUpToValue(int max) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series up to value " + max + ": ");
        while (a <= max) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
