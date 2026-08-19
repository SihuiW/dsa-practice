/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode p1 = head, p2 = head;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode p3 = reverse(p1.next);
        p1.next = null;
        p1 = head;
        while(p3 != null) {
            ListNode next1 = p1.next;
            ListNode next3 = p3.next;
            p1.next = p3;
            p3.next = next1;
            p1 = next1;
            p3 = next3;
        }
    }

    ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}
