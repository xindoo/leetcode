import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<ListNode>();
        Stack<ListNode> stackB = new Stack<ListNode>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode node = null;
        while (stackA.empty() == false && stackB.empty() == false && stackA.peek() == stackB.peek()) {
            node = stackA.peek();
            stackA.pop();
            stackB.pop();
        }
        return node;
    }
}

