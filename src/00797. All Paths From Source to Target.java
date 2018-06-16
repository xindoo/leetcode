import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new LinkedList<>();
        list.add(0);
        helper(graph, 0, list, res);
        return res;
    }
    private void helper(int[][] g, int pos, List<Integer> list, List<List<Integer>> res){
        if(pos == g.length-1){
            res.add(new ArrayList(list));
            return;
        }
        for(int child : g[pos]){
            list.add(child);
            helper(g, child, list, res);
            list.remove(list.size()-1);
        }
    }
}