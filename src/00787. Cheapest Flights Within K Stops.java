import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        for (int i = 0; i <= K; i++) {
            int tmp[] = Arrays.copyOfRange(dis, 0, n);
            for (int [] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int d = flight[2];
                if (dis[u] != Integer.MAX_VALUE && dis[u] + d < tmp[v]) {
                    tmp[v] = dis[u] + d;
                }
            }
            dis = tmp;
        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}