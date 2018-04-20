
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode newhead = pre;
        while (null != p && null != p.next) {
            ListNode q = p.next;
            pre.next = p.next;
            p.next = q.next;
            q.next = p;
            pre = p;
            p = p.next;
        }
        return newhead.next;
    }
}