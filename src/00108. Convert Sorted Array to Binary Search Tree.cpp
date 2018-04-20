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
    TreeNode *sortedArrayToBST(vector<int> &num) {
        return bulidbst(num, 0, num.size()-1);
    }
    TreeNode *bulidbst(vector<int> &num, int l, int r) {
        TreeNode *root;
        if (r < l)
            root = NULL;
        else {
            int mid = (l+r)>>1;
            root = new TreeNode(num[mid]);
            root->left = bulidbst(num, l, mid-1);
            root->right = bulidbst(num, mid+1, r);
        }
        return root;
    }
};