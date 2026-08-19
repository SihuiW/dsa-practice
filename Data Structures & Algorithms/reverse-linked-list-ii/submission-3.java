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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, r = dummy;
        for(int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode l = pre.next;
        for(int i = 0; i < right; i++) {
            r = r.next;
        }
        pre.next = null;
        ListNode tail = r.next;
        r.next = null;
        f(l);
        pre.next = r;
        l.next = tail;
        return dummy.next;

    }

    void f(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
    }
}