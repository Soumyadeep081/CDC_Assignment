package Recursion.Medium;
public class Fibonacci {
    // Brute force: exponential recursion
    static int fibBF(int n) {
        if (n <= 1) return n;
        return fibBF(n - 1) + fibBF(n - 2);
    }

    // Recursive Fibonacci function
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Fibonacci of " + n + " = " + fib(n));

        // Print first n Fibonacci numbers
        System.out.print("Fibonacci series: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
