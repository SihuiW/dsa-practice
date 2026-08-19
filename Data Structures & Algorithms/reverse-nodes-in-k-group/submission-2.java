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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = head;
        int cnt = 0;
        while(l != null) {
            cnt++;
            l = l.next;
        }
        if(cnt < k) return head;
        ListNode r = head;
        for(int i = 0; i < k - 1; i++) r = r.next;
        ListNode tail = r.next;
        r.next = null;
        ListNode nh = reverse(head);
        head.next = reverseKGroup(tail, k);
        return nh;

    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nh = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nh;
    }
}
