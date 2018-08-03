/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            Node childp = p.child;
            while (childp.next != null) {
                childp = childp.next;
            }
            childp.next = p.next;
            if (p.next != null) {
                p.next.prev = childp;
            }
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}