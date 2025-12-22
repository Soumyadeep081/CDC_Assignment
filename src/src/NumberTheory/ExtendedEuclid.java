package NumberTheory;
public class ExtendedEuclid {

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

    public static void main(String[] args) {
        int[] xy = new int[2];
        System.out.println(gcdExtended(30, 20, xy));
        System.out.println("x = " + xy[0] + ", y = " + xy[1]);
    }
}
