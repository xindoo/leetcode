public class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] uglys = new int[n];
        int[] p = new int[k];
        uglys[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                while (primes[j] * uglys[p[j]] <= uglys[i-1]) {
                    p[j]++;
                }
            }
            uglys[i] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (primes[j] * uglys[p[j]] > uglys[i - 1]) {
                    uglys[i] = Math.min(primes[j] * uglys[p[j]], uglys[i]);
                }
            }
        }
        return uglys[n-1];
    }
}