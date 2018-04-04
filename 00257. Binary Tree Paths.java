import java.util.List;

import java.util.ArrayList;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (null == root) {
            return res;
        }
        if (null == root.left && null == root.right) {
            res.add(""+root.val);
        }
        if (null != root.left) {
            for (String str : binaryTreePaths(root.left)) {
                res.add("" + root.val + "->" + str);
            }
        }
        if (null != root.right) {
            for (String str : binaryTreePaths(root.right)) {
                res.add("" + root.val + "->" + str);
            }
        }
        return res;
    }
}