/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode p = head;
        int carrier = (l1.val + l2.val) / 10;
        for (ListNode p1 = l1.next, p2 = l2.next; p1 != null || p2 != null; ) {
            if (p1 == null) {
                while (p2 != null) {
                    ListNode tmp = new ListNode((p2.val + carrier) % 10);
                    carrier = (p2.val + carrier) / 10;
                    p.next = tmp;
                    p = p.next;
                    p2 = p2.next;
                }
            } else if (p2 == null) {
                while (p1 != null) {
                    ListNode tmp = new ListNode((p1.val + carrier) % 10);
                    carrier = (p1.val + carrier) / 10;
                    p.next = tmp;
                    p = p.next;
                    p1 = p1.next;
                }
            } else {
                ListNode tmp = new ListNode((p1.val + p2.val + carrier) % 10);
                carrier = (p1.val + p2.val + carrier) / 10;
                p.next = tmp;
                p = p.next;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        if (carrier != 0) {
            ListNode tmp = new ListNode(carrier);
            p.next = tmp;
        }
        return head;
    }
}
