import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int maxcnt = 0;
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];
        helper(root);
        List<Integer> res = new LinkedList<>();
        for(Map.Entry<Integer, Integer> me: map.entrySet()){
            if(me.getValue() == maxcnt) {
                res.add(me.getKey());
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    int helper(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int sumleft = helper(root.left);
        int sumrigh = helper(root.right);
        Integer sum = root.val + sumleft + sumrigh;
        map.put(sum, map.getOrDefault(sum,0)+1);
        maxcnt = Math.max(maxcnt, map.get(sum));
        return sum;
    }
}