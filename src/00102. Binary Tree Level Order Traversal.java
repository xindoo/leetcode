
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (null == root)
            return res;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root);
        while(q1.size() != 0) {
            List list = new ArrayList();
            while (q1.size() > 0) {
                TreeNode node = q1.poll();
                list.add(node.val);
                if (node.left != null)
                    q2.add(node.left);
                if (node.right != null)
                    q2.add(node.right);
            }
            res.add(list);
            Queue<TreeNode> tq = q1;
            q1 = q2;
            q2 = tq;
        }
        return res;
    }
}