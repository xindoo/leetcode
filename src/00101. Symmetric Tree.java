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
    boolean judge(TreeNode l, TreeNode r) {
        if (null == l && null == r) {
            return true;
        } else if (null == l && null != r || null != l && null == r) {
            return false;
        } else {
            if (l.val != r.val) {
                return false;
            }
            return judge(l.left, r.right) && judge(l.right, r.left);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (null == root)
            return true;
        return judge(root.left, root.right);
    }
}
