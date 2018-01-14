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
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        int ret=kthSmallest(root.left, k);
        if (0 != ret)
            return ret;
        if(++count == k) 
            return root.val;
        return kthSmallest(root.right, k);
    }
}