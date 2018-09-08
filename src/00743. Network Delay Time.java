class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
         int[][] dis = new int[N+1][N+1];
         for (int i = 1; i <= N; i++) {
             for (int j = 1; j <= N; j++) {
                 if (i == j) {
                     continue;
                 }
                 dis[i][j] = 0x3f3f3f3f;
             }
         }
         for (int i = 0; i < times.length; i++) {
             dis[times[i][0]][times[i][1]] = times[i][2];
         }
         for (int k = 1; k <= N; k++) {
             for (int i = 1; i <= N; i++) {
                 for (int j = 1; j <= N; j++) {
                     dis[i][j] = Math.min(dis[i][k]+dis[k][j], dis[i][j]);
                 }
             }
         }
         int max = 0;
         for (int i = 1; i <= N; i++) {
             if (i == K) {
                 continue;
             }
             max = Math.max(max, dis[K][i]);
         }
         if (max == 0x3f3f3f3f) {
             return -1;
         }
         return max;
    }
}