import java.util.ArrayList;
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if (null == root)
            return list;
        if (null != root.left) {
            List<List<Integer>> listleft = pathSum(root.left, sum - root.val);
            for (int i = 0; i < listleft.size(); i++) {
                List<Integer> sublist = new ArrayList<Integer>();
                sublist.add(root.val);
                sublist.addAll(listleft.get(i));
                list.add(sublist);
            }
        }
        if (null != root.right) {
            List<List<Integer>> listright = pathSum(root.right, sum - root.val);
            for (int i = 0; i < listright.size(); i++) {
                List<Integer> sublist = new ArrayList<Integer>();
                sublist.add(root.val);
                sublist.addAll(listright.get(i));
                list.add(sublist);
            }
        }
        if (null == root.left && null == root.right) {
            if (sum == root.val) {
                List<Integer> sublist = new ArrayList<Integer>();
                sublist.add(root.val);
                list.add(sublist);
            }
        }
        return list;
    }
}