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
    private TreeNode treeRoot = null;
    public boolean findTarget(TreeNode root, int k) {
        if (treeRoot == null) {
            treeRoot = root;
        }
        if (root == null) {
            return false;
        }
        if (findElement(treeRoot, root, k)) {
            return true;
        }
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    private boolean findElement(TreeNode root, TreeNode v, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k - v.val && root != v) {
            return true;
        } else if (root.val > k-v.val) {
            return findElement(root.left, v, k);
        } else {
            return findElement(root.right, v, k);
        }
    }
}