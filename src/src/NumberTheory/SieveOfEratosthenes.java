package NumberTheory;

import java.util.*;

public class SieveOfEratosthenes {

    static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        boolean[] primes = sieve(30);
        for (int i = 2; i <= 30; i++) {
            if (primes[i]) System.out.print(i + " ");
        }
    }
}

