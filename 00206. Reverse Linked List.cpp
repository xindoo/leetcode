/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (NULL == head || NULL == head->next)
            return head;
        ListNode* p = head, *q = head->next, *tmp;
        head->next = NULL;
        while (NULL != q) {
            tmp = q->next;
            q->next = p;
            p = q;
            q = tmp;
        }
        return p;
    }
};