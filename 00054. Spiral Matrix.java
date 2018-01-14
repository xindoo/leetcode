import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if (0 == matrix.length)
            return ans;
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        int[] diri = {0, 1, 0, -1};
        int[] dirj = {1, 0, -1, 0};
        int dir = 0;
        int curi = 0, curj = 0;
        ans.add(matrix[0][0]);
        vis[0][0] = true;
        while (matrix.length*matrix[0].length != ans.size()) {
            int nexti = curi + diri[dir];
            int nextj = curj + dirj[dir];
            if (nexti == matrix.length || nexti < 0 || nextj == matrix[0].length || nextj <0 || vis[nexti][nextj] == true) {
                dir = (dir+1)%4;
                continue;
            }
            curi = nexti;
            curj = nextj;
            ans.add(matrix[curi][curj]);
            vis[curi][curj] = true;
        }
        return ans;
    }
}