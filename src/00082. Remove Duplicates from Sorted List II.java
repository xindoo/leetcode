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
        if (null == head){
            return null;
        }
        ListNode newhead = new ListNode(Integer.MIN_VALUE);
        newhead.next = head;
        ListNode pre = newhead;
        ListNode p = newhead.next;
        while (p != null) {
            boolean isDup = false;
            while (true) {
                if (p.next != null && p.val == p.next.val) {
                    isDup = true;
                    p = p.next;
                } else {
                    break;
                }
            }
            if (!isDup) {
                pre.next = p;
                pre = pre.next;
            }
            p = p.next;
        }
        pre.next = null;
        return newhead.next;
    }
}