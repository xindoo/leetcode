/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode *sortedListToBST(ListNode *head) {
        if (NULL == head)
            return NULL;
        TreeNode *root = NULL;
        int cnt = 0;
        ListNode *p = head;
        while (NULL != p) {
            cnt++;
            p = p->next;
        }
        p = head;
        if (1 == cnt) {
            return new TreeNode(p->val);
        }
        int mid = cnt>>1;
        for (int i = 1; i < mid; i++) {
            p = p->next;
        }
        ListNode *q = p->next;
        p->next = NULL;
        root = new TreeNode(q->val);
        q = q->next;
        root->left = sortedListToBST(head);
        root->right = sortedListToBST(q);
        return root;
    }
};