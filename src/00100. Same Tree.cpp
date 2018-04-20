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
    bool isSameTree(TreeNode *p, TreeNode *q) {
        if (NULL == p && NULL != q || NULL != p && NULL == q)
            return false;
        else if (NULL == p && NULL == q) 
            return true;
        if (p->val != q->val)
            return false;
        if (isSameTree(p->left, q->left))
            return isSameTree(p->right, q->right);
        return false;
    }
};
