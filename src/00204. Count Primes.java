class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1)
            return 0;
        boolean[] v = new boolean[n];
        int res = n-2;
        for (int i = 2; i * i < n; i++) {
            if (v[i]) 
                continue;
            for (int j = i+i; j < n; j += i) {
                if (v[j])
                    continue;
                res--;
                v[j]= true;
            }
        }
        return res;
    }
}