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
    int mindepth = 0;
    int minDepth(TreeNode *root) {
        if (NULL == root)
            return 0;
        else 
            mindepth = 0x3f3f3f3f;
        dfs(root, 1);
        return mindepth;
    }
    
    void dfs(TreeNode *root, int depth) {
        if (NULL != root->left)
            dfs(root->left, depth+1);
        if (NULL != root->right)
            dfs(root->right, depth+1);
        if (NULL == root->left && NULL == root->right)
            mindepth = min(mindepth, depth);
    }
};