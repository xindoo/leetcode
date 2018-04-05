
import java.util.Stack;

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
    public int findSecondMinimumValue(TreeNode root) {
        if (null == root) {
            return -1;
        }
        int min = root.val;
        int smin = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            if (node.val < min) {
                smin = min;
                min = node.val;
                continue;
            }
            if (node.val < smin && node.val > min) {
                smin = node.val;
            }
        }
        return smin==Integer.MAX_VALUE?-1:smin;
    }
}