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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode liftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p,  q);
        if (null != liftLCA && null != rightLCA) {
            return root;
        } 
        return liftLCA != null ? liftLCA : rightLCA;
    }
}