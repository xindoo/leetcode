/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode *root) {
        if (NULL == root)
            return 0;
        int l = maxDepth(root->left);
        int r = maxDepth(root->right);
        return max(l, r) +1;
    }
};