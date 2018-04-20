import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode p = newhead;
        while (null != p) {
            len += 1;
            p = p.next;
        }
        p = newhead;
        int cnt = len - n - 1 ;
        while (cnt != 0) {
            p = p.next;
            cnt--;
        }
        p.next = p.next.next;
        return newhead.next;
    }
}