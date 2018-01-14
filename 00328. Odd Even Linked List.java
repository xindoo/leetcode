public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode la = null;
        ListNode pa = null;
        ListNode lb = null;
        ListNode pb = null;
        int cnt = 1;
        while (null != head) {
            if (cnt%2 == 1) {
                if (null == la) {
                    la = head;
                    pa = la;
                }
                else {
                    pa.next = head;
                    pa = pa.next;
                }
            }
            else {
                if (null == lb) {
                    lb = head;
                    pb = lb;
                }
                else {
                    pb.next = head;
                    pb = pb.next;
                }
            }
            head = head.next;
            cnt += 1;
        }
        if (null != pa)
            pa.next = null;
        if (null != pb)
            pb.next = null;
        if (null == pa)
            return lb;
        pa.next = lb;
        return la;
    }
}