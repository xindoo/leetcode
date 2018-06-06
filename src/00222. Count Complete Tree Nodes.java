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
    private int getHeight(TreeNode root) {
        if (null == root)
            return -1;
        return getHeight(root.left)+1;
    }
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        if (-1 == h)
            return 0;
        if (getHeight(root.right) == h-1) 
            return (1<<h) + countNodes(root.right);
        else 
            return (1 << h-1) + countNodes(root.left);
    }
}