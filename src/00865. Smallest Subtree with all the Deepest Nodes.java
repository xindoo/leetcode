import java.util.HashMap;
import java.util.Map;

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
    private int maxDepth = 0;
    private Map<TreeNode, Integer> map;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        map = new HashMap<TreeNode, Integer>();
        getMaxDpeth(root, 0);
        return helper(root);
    }
    private int getMaxDpeth(TreeNode root,  int depth) {
        if (root == null)
            return 0;
        if (depth > maxDepth)
            maxDepth = depth;
        if (map.containsKey(root))
            return map.get(root);
        int d = Math.max(getMaxDpeth(root.left, depth+1), getMaxDpeth(root.right,depth+1));
        map.put(root, d+depth);
        return d+1;
    }

    private TreeNode helper(TreeNode root) {
        if (root == null )
            return root;
        if (getMaxDpeth(root.left, 0) == maxDepth && getMaxDpeth(root.right, 0) == maxDepth) {
            System.out.println(maxDepth);
            return root;
        }
        TreeNode nodeleft = helper(root.left);
        if (nodeleft != null)
            return nodeleft;
        TreeNode noderight = helper(root.right);
        if (noderight != null)
            return noderight;
        if (map.get(root) == maxDepth)
            return root;
        return null;
    }
}