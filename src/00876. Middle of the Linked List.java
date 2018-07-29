/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        cnt /=2;
        p = head;
        while (cnt>0) {
            p = p.next;
            cnt--;
        }
        return p;
    }
}