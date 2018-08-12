class Solution {
    boolean[][] map;
    int[] group;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        map = new boolean[N+1][N+1];
        group = new int[N+1];
        for (int i = 0; i < dislikes.length; i++) {
            int x = dislikes[i][0];
            int y = dislikes[i][1];
            map[x][y] = true;
            map[y][x] = true;
        }
        for (int i = 1; i <= N; i++) {
            if (group[i] == 0) {
                group[i] = 1;
                if (dfs(i, 1) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int x, int g) {
        for (int i  = 1; i < group.length; i++) {
            if (map[x][i] == true) {
                if (group[i] == g) {
                    return false;
                } 
                if (group[i] == 0) {
                    group[i] = -g;
                    if (dfs(i, -g) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}