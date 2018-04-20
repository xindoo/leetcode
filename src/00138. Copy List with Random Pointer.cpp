/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    void CloneNode(RandomListNode *head) {
        RandomListNode * p = head;
        while (NULL != p) {
            RandomListNode * CloneNode = new RandomListNode(p->label);
            CloneNode->next = p->next;
            CloneNode->random = p->random;
            p->next = CloneNode;
            p = CloneNode->next;
        }
    }
    
    void ConnectRandomNode(RandomListNode * head) {
        RandomListNode * p = head;
        while (NULL != p) {
            RandomListNode *pclone = p->next;
            if (pclone->random) {
                pclone->random = pclone->random->next;
            }
            p = pclone->next;
        }
    }
    RandomListNode *copyRandomList(RandomListNode *head) {
        if (NULL == head)
            return head;
        CloneNode(head);
        ConnectRandomNode(head);
        RandomListNode *pnode = head;
        RandomListNode *pclonehead = pnode->next;
        RandomListNode *pclonenode = pnode->next;
        while (NULL != pnode) {
            pnode->next = pclonenode->next;
            pnode = pnode->next;
            if (NULL != pnode){
                 pclonenode->next = pnode->next;
                 pclonenode = pclonenode->next;
            }
        }
        return pclonehead;
    }
    
};