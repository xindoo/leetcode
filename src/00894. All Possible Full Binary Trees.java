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
    public List<TreeNode> allPossibleFBT(int N) {
        if (0 == N) {
            return null;
        }
        List<TreeNode> nodes  = new LinkedList<>();
        if (N == 1) {
            nodes.add(new TreeNode(0));
            return nodes;
        }

        for (int k = 1; k < N-1; k++) {
            List<TreeNode> left = allPossibleFBT(k);
            List<TreeNode> right = allPossibleFBT(N - 1 - k);
            for (int i = 0; i < left.size(); i++) {
                for (int j = 0; j < right.size(); j++) {
                    TreeNode root = new TreeNode(0);
                    root.left = copy(left.get(i));
                    root.right = copy(right.get(j));
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }
    private TreeNode copy(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode newroot = new TreeNode(0);
        newroot.left = copy(root.left);
        newroot.right = copy(root.right);
        return newroot;
    }
}