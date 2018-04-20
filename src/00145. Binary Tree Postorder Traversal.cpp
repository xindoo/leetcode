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
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> v;
        if (NULL == root)
            return v;
        stack<TreeNode*> s;
        s.push(root);
        TreeNode * pre = root;
        while (!s.empty()) {
            TreeNode * cur = s.top();
            if ((NULL == cur->left && NULL == cur->right) || (pre == cur->left || pre == cur->right)) {
                s.pop();
                v.push_back(cur->val);
                pre = cur;
            }
            else {
                if (cur->right)
                    s.push(cur->right);
                if (cur->left)
                    s.push(cur->left);
            }
        }
        return v;
    }
};