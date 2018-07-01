import java.util.LinkedList;
import java.util.List;

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
    private boolean findTarget = false;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        help(root, target, K, res);
        return res;
    }

    private void  help(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null)
            return;
        if (root == target) {
            helper(root, K, res);
        } else {
            if (hasTarget(root.left, target, K-1) || hasTarget(root.right, target, K-1)) {
                res.add(root.val);
            } else {
                for (int i = 1; i < K; i++) {
                    if (hasTarget(root.left, target, i - 1)) {
                        helper(root.right, K - i - 1, res);
                    }
                    if (hasTarget(root.right, target, i - 1)) {
                        helper(root.left, K - i - 1, res);
                    }
                }
            }
        }
        help(root.left, target, K, res);
        help(root.right, target, K, res);
    }

    private boolean hasTarget(TreeNode root, TreeNode target, int step) {
        if (root == null)
            return false;
        if (step == 0 && root == target)
            return true;
        return hasTarget(root.left, target, step-1) || hasTarget(root.right, target, step-1);
    }
    private  void helper(TreeNode root, int step, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (step == 0) {
            res.add(root.val);
        }
        helper(root.left, step-1, res);
        helper(root.right, step-1, res);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        a.right = c;
        a.left = b;
        Solution s = new Solution();
        s.distanceK(a, c, 1);
    }
}