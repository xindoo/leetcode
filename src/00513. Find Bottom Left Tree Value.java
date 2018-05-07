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
    private int depth = 0;
    private int value;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1);
        return value;
    }
    public void helper(TreeNode root, int d) {
        if (null == root)
            return;
        if (d > depth) {
            depth = d;
            value = root.val;
        }
        helper(root.left, d+1);
        helper(root.right, d+1);
    }
}