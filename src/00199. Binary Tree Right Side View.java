
import java.util.*;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (null == root) {
            return list;
        }
        Queue<TreeNode> treequeue = new ArrayDeque<TreeNode>();
        Queue<Integer> depthqueue = new ArrayDeque<Integer>();
        treequeue.add(root);
        depthqueue.add(1);
        int lastdepth = 0;
        TreeNode lastnode = null;
        while (!treequeue.isEmpty()) {
            TreeNode node = treequeue.poll();
            int depth = depthqueue.poll();
            if (lastdepth != depth && null != lastnode) {
                list.add(lastnode.val);
            }
            if (node.left != null) {
                treequeue.add(node.left);
                depthqueue.add(depth+1);
            }
            if (node.right != null) {
                treequeue.add(node.right);
                depthqueue.add(depth+1);
            }
            lastnode = node;
            lastdepth = depth;
        }
        list.add(lastnode.val);
        return list;
    }
}