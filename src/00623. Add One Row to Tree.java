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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (null == root)
            return null;
        if (1 == d) {
            TreeNode left = new TreeNode(v);
            left.left = root;
            root = left;
        }
        else if (2 == d) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        }
        else {
            addOneRow(root.left,  v, d-1);
            addOneRow(root.right, v, d-1);
        }
        return root;
    }
}