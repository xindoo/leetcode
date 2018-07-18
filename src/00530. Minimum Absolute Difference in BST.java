
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
    private int minval = Integer.MAX_VALUE;
    private int pre;
    public int getMinimumDifference(TreeNode root) {
        minval = Integer.MAX_VALUE;
        pre = -1;
        helper(root);
        return minval;
    }
    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        if(pre != -1) {
            minval = Math.min(minval, root.val- pre);
            pre = root.val;
        }
        pre = root.val;
        helper(root.right);
    }
}