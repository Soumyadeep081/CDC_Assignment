package Math;

public class Permutation {
    static int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    public static int nPr(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    public static void main(String[] args) {
        System.out.println(nPr(5, 2));
    }
}

