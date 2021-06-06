package leetcode;

import java.util.HashSet;

public class CountPrimes {

    static int eratosthenes(int n) {
        boolean[] sieve = new boolean[n];

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!sieve[i]) {
                for (int j = i + i; j < n; j += i) {
                    sieve[j] = true;
                }
            }
        }

        int primes = 0;
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) primes++;
        }

        return primes;
    }

    static int countPrimes(int n) {
        HashSet<Integer> primeMultiplies = new HashSet<>();
        int primes = 0;
        for (int i = 2; i < n; i++) {
            if (!primeMultiplies.contains(i)) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i) && isPrime; j++) {
                    if (i % j == 0) isPrime = false;
                }

                if (isPrime) {
                    // is prime
                    primes++;
                    for (int j = i; j <= n; j++) {
                        if (j % i == 0) {
                            primeMultiplies.add(j);
                        }
                    }
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
//        System.out.println(eratosthenes(499979));
//        System.out.println(countPrimes(4999));
//        System.out.println(countPrimes(10));
        System.out.println(eratosthenes(3));
    }
}
