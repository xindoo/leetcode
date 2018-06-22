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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (null == root)
            return res;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root);
        while (!q1.isEmpty()) {
            int maxval = Integer.MIN_VALUE;
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                maxval = Math.max(node.val, maxval);
                if (node.left != null)
                    q2.add(node.left);
                if (node.right != null)
                    q2.add(node.right);
            }
            Queue<TreeNode> tmp = q1;
            q1 = q2;
            q2 = tmp;
            res.add(maxval);
        }
        return res;
    }
}