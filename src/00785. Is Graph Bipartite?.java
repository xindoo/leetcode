/**
 * 刚看到这个题的时候, 我有点想歪了, 想到了二分图的最大匹配, 反正我是不会的. 
 * 突然一瞬间我想到不就是两类吗, 每个节点要么属于1类,要么属于-1类, 所以可以
 * 这样, 遍历 如果遇到一个未分组的就默认分到1组, 和它管理的节点就分到-1组了,
 * 和-1组相关联的节点肯定是被分到1组的, 就这样用dfs或者bfs, 逐个给每个点分组.
 * 如果发现有个节点之前被分到一组了,后面又被分到另一组了, 肯定是无法满足题目
 * 要求的划分的, 返回false即可.  
 */

class Solution {
    int[] group;
    public boolean isBipartite(int[][] graph) {
        group = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (group[i] != 0) {
                continue;
            }
            group[i] = 1;
            if (!dfs(graph, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int x) {
        for (int i = 0; i < graph[x].length; i++) {
            if (group[graph[x][i]] == 0) {
                group[graph[x][i]] = -group[x];
                if (!dfs(graph, graph[x][i])) {
                    return false;
                }
            }
            if (group[graph[x][i]] != -group[x]) {
                return false;
            }
        }
        return true;
    }
}