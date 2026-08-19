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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = 0;
        ListNode tail = head;
        ListNode p = head;
        while(tail != null) {
            tail = tail.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode l = head, r = head;
        for(int i = 0; i < k; i++) {
            r = r.next;
        }
        while(r.next != null) {
            r = r.next;
            l = l.next;
        }
        ListNode newHead = l.next;
        l.next = null;
        r.next = head;
        return newHead;

    }
}