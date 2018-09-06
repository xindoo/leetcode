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
    private int sum;

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        sum = 0;
        helper(0, root);
        return sum;
    }

    private void helper(int v, TreeNode root) {
        if (root.left != null) {
            helper((v + root.val) * 10, root.left);
        }
        if (root.right != null) {
            helper((v + root.val) * 10, root.right);
        }
        if (root.left == null && root.right == null) {
            sum += v + root.val;
        }
    }
}
        