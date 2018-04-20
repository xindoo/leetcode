public class Solution {
    int cnt = 0;

    public int countArrangement(int N) {
        if (N == 0) return 0;
        check(N, 1, new int[N + 1]);
        return cnt;
    }

    private void check(int N, int pos, int[] vis) {
        if (pos > N) {
            cnt++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (vis[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                vis[i] = 1;
                check(N, pos + 1, vis);
                vis[i] = 0;
            }
        }
    }
}