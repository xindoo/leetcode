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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) 
            return null;
        return buildTree(nums, 0, nums.length);
    }
    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        if (r - l == 1) {
            return new TreeNode(nums[l]);
        }
        int maxv = Integer.MIN_VALUE;
        int maxp = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > maxv) {
                maxv = nums[i];
                maxp = i;
            }
        }
        TreeNode root = new TreeNode(maxv);
        root.left = buildTree(nums, l, maxp);
        root.right = buildTree(nums, maxp+1, r);
        return root;
    }
}