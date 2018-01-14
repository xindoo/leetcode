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
    int sumNumbers(TreeNode *root) {
        if (NULL == root)
            return 0;
        ans = 0;
        dfs(root, 0);
        return ans;
    }
    void dfs(TreeNode *root, int sum) {
        sum *= 10;
        sum += root->val;
        if (NULL == root->left && NULL == root->right) {
            ans += sum;
        }
        if (root->left != NULL)
            dfs(root->left, sum);
        if (root->right != NULL)
            dfs(root->right, sum);
    }
private:
    int ans = 0;
};