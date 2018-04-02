import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class Pair{
        public TreeLinkNode node;
        public int d;
        Pair(TreeLinkNode root, int d) {
            this.node = root;
            this.d = d;
        }
    }

    public void connect(TreeLinkNode root) {
        if (null == root) return;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(root, 1));
        TreeLinkNode node = new TreeLinkNode(0);
        int depth = 0;
        while (!queue.isEmpty()) {
            if (depth != queue.peek().d) {
                node.next = null;
                node = queue.poll().node;
                depth += 1;
            } else {
                node.next = queue.poll().node;
                node = node.next;
            }
            if (node.left != null) {
                queue.add(new Pair(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, depth + 1));
            }
        }
    }
}