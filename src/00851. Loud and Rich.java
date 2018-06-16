class Solution {
    private boolean[][] relationMatrix;
    private int[] ans;
    private int dfs(int[] quiet, int pos){
        if (ans[pos] != -1) {
            return ans[pos];
        }
        ans[pos] = pos;
        for (int i = 0; i < quiet.length; i++) {
            if (relationMatrix[pos][i]) {
                int tmp = dfs(quiet, i);
                if (quiet[ans[pos]] > quiet[tmp]){
                    ans[pos] = tmp;
                }
            }
        }
        return ans[pos];
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        relationMatrix = new boolean[n][n];
        ans = new int[n];
        for (int i = 0; i < richer.length; i++) {
            relationMatrix[richer[i][1]][richer[i][0]] = true;
        }
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                ans[i] = dfs(quiet, i);
            }
        }
        return ans;
    }
}