package NumberTheory;
public class ModularArithmetic {

    static int modAdd(int a, int b, int m) {
        return ((a % m) + (b % m)) % m;
    }

    static int modMul(int a, int b, int m) {
        return (int)(((long) (a % m) * (b % m)) % m);
    }

    static int modExp(int base, int exp, int mod) {
        int result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (int)(((long) result * base) % mod);
            base = (int)(((long) base * base) % mod);
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(modAdd(5, 7, 10));
        System.out.println(modMul(5, 7, 10));
        System.out.println(modExp(2, 10, 1000));
    }
}
