public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null == root)
            return true;
        if (null == root.left && null==root.right) {
            root.val = 1;
            return true;
        }
        if (!isBalanced(root.left))
            return false;
        if (!isBalanced(root.right))
            return false;
        if (null != root.left && null == root.right) {
            if (root.left.val > 1)
                return false;
            root.val = 2;
        }
        else if (null == root.left && null != root.right) {
            if (root.right.val > 1)
                return false;
            root.val = 2;
        }
        else {
            if (Math.abs(root.left.val - root.right.val) > 1)
                return false;
            root.val = Math.max(root.left.val, root.right.val)+1;
        }
        return true;
    }
}