/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (null == root)
            return;
        TreeNode right = root.right;
        TreeNode lift = root.left;
        root.right = lift;
        root.left = null;
        if (null != lift)
            flatten(lift);
        if (null != right)
            flatten(right);
        TreeNode p = root;
        while (p.right != null)
            p = p.right;
        p.right = right;
    }
}