/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || 0 == lists.length) 
            return null;
        ListNode head = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode list:lists) {
            if (list != null)
                pq.add(list);
        }
        ListNode p = head;
        while (!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            if (p.next != null)
                pq.add(p.next);
        }
        return head.next;
    }
}

