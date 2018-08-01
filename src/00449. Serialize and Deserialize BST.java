
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
//public class Solution{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root)
            return "";
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuffer sb = new StringBuffer("0");
        queue.push(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(",").append(node.val);
            if (node.left != null)
                queue.push(node.left);
            if (node.right != null)
                queue.push(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        if (strs.length < 2)
            return null;
        List<Integer> list = Arrays.stream(strs).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
        TreeNode root = new TreeNode(list.get(1));
        for (int i = 2; i < list.size(); i++) {
            insertBST(root, list.get(i));
        }
        return root;
    }
    private void insertBST(TreeNode root, int x) {
        if (root.val < x) {
            if (root.right == null) {
                root.right = new TreeNode(x);
            } else {
                insertBST(root.right, x);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(x);
            } else {
                insertBST(root.left, x);
            }
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));