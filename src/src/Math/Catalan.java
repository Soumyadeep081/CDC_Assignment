package Math;
public class Catalan {
    public static int catalan(int n) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = res * 2 * (2L * i + 1) / (i + 2);
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(catalan(5));
    }
}
