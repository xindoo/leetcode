import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<Integer[]> list = new ArrayList<>();
        int[] dirx = new int[]{0, 1, 0, -1};
        int[] diry = new int[]{1, 0, -1, 0};
        int cnt = C*R;
        int dir = 0;
        int x = r0; int y = c0;
        int steps = 0;
        if (judge(x, y, R, C)) {
            Integer[] subans = new Integer[]{x, y};
            list.add(subans);
            cnt--;
        }
        while (cnt > 0) {
            int step = steps/2+1;
            steps++;
            for (int i = 0; i < step; i++) {
                x = x + dirx[dir];
                y = y + diry[dir];
                if (judge(x, y, R, C)) {
                    Integer[] subans = new Integer[]{x, y};
                    list.add(subans);
                    cnt--;
                }
            }
            dir += 1;
            if (dir == 4)
                dir = 0;
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
    private boolean judge(int i, int j, int R, int C) {
        if (i < 0 || i >= R)
            return false;
        if (j < 0 || j >= C )
            return false;
        return true;
    }
}