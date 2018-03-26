import java.util.HashMap;
import java.util.Map;

class Solution {
    private int dis(int[] a, int[] b) {
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int d = dis(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (int val : map.values()) {
                cnt += val*(val-1);
            }
            map.clear();
        }
        return cnt;
    }
}