import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer>  list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        for (int i = 0; i < list.size()/2; i++) {
            System.out.println(list.get(i) + " " + list.get(list.size()-1-i));
            if (!list.get(i).equals(list.get(list.size()-1-i))) {
                return false;
            }
        }
        return true;
    }
}