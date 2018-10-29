## 题意
　　二叉搜索树的节点删除。　　 
## 思路
　　当然先是找到要删除的节点，然后在左子树里找到最大的节点替换掉，当前节点，递归删除左子树里最大的节点。当然从右子树里找最小的也是一样的。  

```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left != null && root.right != null) {
                TreeNode maxleft = findMaxLeft(root.left);
                root.val = maxleft.val;
                root.left = deleteNode(root.left, root.val);
            } else {
                return root.left == null ? root.right : root.left;
            }
        }
        return root;
    }

    private TreeNode findMaxLeft(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.right != null) {
            root = findMaxLeft(root.right);
        }
        return root;
    }
}
```