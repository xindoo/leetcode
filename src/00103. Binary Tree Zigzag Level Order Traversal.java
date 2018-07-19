import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        int reverse = 1;
        q1.add(root);
        while (!q1.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            List<Integer> sublist = new ArrayList<>();
            if (reverse == 1) {
                sublist.addAll(tmp);
            } else {
                for (int i = tmp.size()-1; i >= 0; i--) {
                    sublist.add(tmp.get(i));
                }
            }
            res.add(sublist);
            reverse = -1*reverse;
            Queue<TreeNode> t = q1;
            q1 = q2;
            q2 = t;
        }
        return res;
    }
}