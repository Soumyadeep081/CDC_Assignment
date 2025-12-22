package NumberTheory;

import java.util.*;

public class ChineseRemainder {

    static int modInverse(int a, int m) {
        int[] xy = new int[2];
        int g = gcdExtended(a, m, xy);
        return g == 1 ? (xy[0] % m + m) % m : -1;
    }

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

    static int crt(int[] num, int[] rem) {
        int prod = 1;
        for (int n : num) prod *= n;

        int result = 0;
        for (int i = 0; i < num.length; i++) {
            int pp = prod / num[i];
            result += rem[i] * modInverse(pp, num[i]) * pp;
        }
        return result % prod;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, 5};
        int[] rem = {2, 3, 1};
        System.out.println(crt(num, rem));
    }
}
