package Math;
public class Combination {
    static int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    public static int nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        System.out.println(nCr(5, 2));
    }
}
