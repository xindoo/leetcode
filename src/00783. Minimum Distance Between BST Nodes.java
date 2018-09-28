/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 二叉搜索树, 任意两个节点的最小差肯定是中序遍历结果中相邻两个节点的差值.
 */
class Solution {
    private int min;
    private int pre;
    public int minDiffInBST(TreeNode root) {
        pre = Integer.MIN_VALUE/2;
        min = Integer.MAX_VALUE/2;
        inorder(root);
        return min;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        min = Math.min(min, root.val - pre);
        pre = root.val;
        inorder(root.right);
    }
}