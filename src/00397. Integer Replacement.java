class Solution {
    private int min;
    public int integerReplacement(int n) {
        min = Integer.MAX_VALUE;
        dfs(n, 0);
        return min;
    }
    private void dfs(long n, int cnt) {
        if (n == 1) {
            min = Math.min(cnt, min);
            return;
        }
        if (n %2 == 0) {
            dfs(n >> 1, cnt+1);
        } else {
            dfs(n + 1, cnt + 1);
            dfs(n - 1, cnt + 1);
        }
    }
}