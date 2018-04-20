/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (NULL == root)
            return;
        queue<TreeLinkNode *> myq;
        myq.push(root);
        int cnt = 1;
        int pow = 1;
        TreeLinkNode *p;
        while (!myq.empty()) {
            if (cnt == pow) {
                p = myq.front();
                p->next = NULL;
                myq.pop();
                pow <<= 1;
            }
            else {
                TreeLinkNode *q = myq.front();
                myq.pop();
                p->next = q;
                p = q;
                q->next = NULL;
            }
            if (p->left)
                myq.push(p->left);
            if (p->right)
                myq.push(p->right);
            cnt++;
        }
    }
};