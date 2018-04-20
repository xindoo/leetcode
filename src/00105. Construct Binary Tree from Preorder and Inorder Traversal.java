import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(0 == preorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int pos = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                pos = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos+1), Arrays.copyOfRange(inorder, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(preorder, pos+1, preorder.length), Arrays.copyOfRange(inorder, pos+1, inorder.length));
        return root;
    }
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        int[] b = Arrays.copyOfRange(a, 0, 8);
        int[] c = Arrays.copyOfRange(a, 3, 7);
        System.out.println("dfsfsdf");
    }
}