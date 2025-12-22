package Math;
import java.util.*;

public class CoprimeCount {
    public static int solve(int n, int r) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                primes.add(i);
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) primes.add(n);

        int sum = 0;
        int sz = primes.size();

        for (int mask = 1; mask < (1 << sz); mask++) {
            int mult = 1, bits = 0;
            for (int i = 0; i < sz; i++) {
                if ((mask & (1 << i)) != 0) {
                    mult *= primes.get(i);
                    bits++;
                }
            }
            int cur = r / mult;
            sum += (bits % 2 == 1) ? cur : -cur;
        }
        return r - sum;
    }

    public static void main(String[] args) {
        System.out.println(solve(12, 20));
    }
}
