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
    Integer val;
    public boolean isValidBST(TreeNode root) {
        if (null == root)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (null != val && val >= root.val)
            return false;
        val = root.val;
        return isValidBST(root.right);
    }
}