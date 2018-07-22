/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        StringBuilder s1 = new StringBuilder(); 
        StringBuilder s2 = new StringBuilder();
        
        helper(root1, s1);
        helper(root2, s2);
        
        return s1.toString().equals(s2.toString());
    }
    
    public void helper(TreeNode root, StringBuilder sb)
    {
        if(root.left == null && root.right == null) 
        {
            sb.append(root.val+"");
            return;
        }
        
        if(root.left != null) helper(root.left, sb);         
        if(root.right != null) helper(root.right, sb);        
    }
}