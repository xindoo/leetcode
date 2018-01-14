/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode la = null;
        ListNode pa = null;
        ListNode lb = null;
        ListNode pb = null;
        while (null != head) {
            if (head.val < x) {
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