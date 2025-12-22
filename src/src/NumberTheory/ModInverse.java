package NumberTheory;
public class ModInverse {

    static int gcdExtended(int a, int b, int[] xy) {
        if (a == 0) {
            xy[0] = 0;
            xy[1] = 1;
            return b;
        }
        int[] xy1 = new int[2];
        int gcd = gcdExtended(b % a, a, xy1);
        xy[0] = xy1[1] - (b / a) * xy1[0];
        xy[1] = xy1[0];
        return gcd;
    }

    static int modInverse(int a, int m) {
        int[] xy = new int[2];
        int g = gcdExtended(a, m, xy);
        if (g != 1) return -1;
        return (xy[0] % m + m) % m;
    }

    public static void main(String[] args) {
        System.out.println(modInverse(3, 11));
    }
}
