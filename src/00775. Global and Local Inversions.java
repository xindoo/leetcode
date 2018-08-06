class Solution {
    private int c[];
    private int lowbit(int x) {
        return  x&(-x);
    }
    private void add(int x) {
        while (x < c.length) {
            c[x] += 1;
            x += lowbit(x);
        }
    }

    private int get(int x) {
        int res = 0;
        while (x > 0) {
            res += c[x];
            x -= lowbit(x);
        }
        return res;
    }
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        c = new int[n+1];
        int local = 0;
        int global = 0;
        add(n - A[0]);
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                local += 1;
            }
            global += get(n - A[i]);
            add(n - A[i]);
        }
        return global == local;
    }
}