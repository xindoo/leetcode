/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head)
            return head;
        ListNode p = head;
        ListNode q = head.next;
        while (true) {
            if (null == q)
                break;
            if (p.val == q.val) {
                p.next = q.next;
                q = q.next;
            } else {
                p = q;
                q = q.next;
            }
        }
        return head;
    }
}