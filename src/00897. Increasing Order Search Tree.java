import java.util.ArrayList;
import java.util.List;

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
    private List<TreeNode> list = null;
    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        mid(root);
        TreeNode newroot = list.get(0);
        TreeNode p = newroot;
        for (int i = 1; i < list.size(); i++) {
            p.left = null;
            p.right = list.get(i);
            p = p.right;
        }
        p.left = null;
        return newroot;
    }
    private void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        list.add(root);
        mid(root.right);
    }
}