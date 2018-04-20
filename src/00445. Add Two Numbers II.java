import java.awt.*;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        ListNode p = l1;
        while (p != null) {
            s1.push(p);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            s2.push(p);
            p = p.next;
        }
        ListNode head = null;
        int sum = 0;
        while (!s1.empty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop().val;
            }
            if (!s2.isEmpty()) {
                sum += s2.pop().val;
            }
            ListNode node = new ListNode(sum%10);
            sum /= 10;
            node.next = head;
            head = node;
        }
        if (sum != 0) {
            ListNode node = new ListNode(sum%10);
            node.next = head;
            head = node;
        }
        return head;
    }
}