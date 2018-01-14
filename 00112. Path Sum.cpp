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
    bool hasPathSum(TreeNode *root, int sum) {
        if (NULL == root)
           return false;
        if (0 == sum - root->val && NULL == root->left && NULL == root->right)
            return true;
        if (hasPathSum(root->left, sum-root->val) == true)
            return true;
        else 
            return hasPathSum(root->right, sum-root->val);
    }
};