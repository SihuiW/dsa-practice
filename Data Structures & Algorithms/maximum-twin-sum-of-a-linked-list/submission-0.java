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
    public int pairSum(ListNode head) {
        int res = 0;
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode newNode = reverse(second);
        ListNode p1 = dummy.next, p2 = newNode;
        while(p1 != null && p2 != null) {
            int num = p1.val + p2.val;
            res = Math.max(res, num);
            p1 = p1.next;
            p2 = p2.next;
        }
        return res;

    }

    ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode newNode = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }
}