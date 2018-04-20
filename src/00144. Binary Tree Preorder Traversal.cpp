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
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> v;
        if (NULL == root)
            return v;
        stack<TreeNode*> s;
        s.push(root);
        while (!s.empty()) {
            TreeNode * tmp = s.top();
            s.pop();
            v.push_back(tmp->val);
            if (tmp->right)
                s.push(tmp->right);
            if (tmp->left)
                s.push(tmp->left);
        }
        return v;
    }
};