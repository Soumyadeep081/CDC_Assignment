package Recursion.Easy;

public class PrintSequences {

    // Brute force
    static void printIncBF(int n) {
        for (int i = 1; i <= n; i++) System.out.print(i + " ");
    }

    static void printDecBF(int n) {
        for (int i = n; i >= 1; i--) System.out.print(i + " ");
    }

    static void printDecIncBF(int n) {
        for (int i = n; i >= 1; i--) System.out.print(i + " ");
        for (int i = 2; i <= n; i++) System.out.print(i + " ");
    }

    // Optimized (Recursion)
    static void printIncOpt(int n) {
        if (n == 0) return;
        printIncOpt(n - 1);
        System.out.print(n + " ");
    }

    static void printDecOpt(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printDecOpt(n - 1);
    }

    static void printDecIncOpt(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printDecIncOpt(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.print("BF inc: ");
        printIncBF(n);
        System.out.println();

        System.out.print("Opt inc: ");
        printIncOpt(n);
        System.out.println();

        System.out.print("BF dec: ");
        printDecBF(n);
        System.out.println();

        System.out.print("Opt dec: ");
        printDecOpt(n);
        System.out.println();

        System.out.print("BF decinc: ");
        printDecIncBF(n);
        System.out.println();

        System.out.print("Opt decinc: ");
        printDecIncOpt(n);
        System.out.println();
    }
}
