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
        if(k <= 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(true) {
            ListNode end = pre;
            for(int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null) break;

            ListNode start = pre.next;
            ListNode nextGroup = end.next;

            ListNode newHead = reverse(start, end.next);
            pre.next = newHead;
            start.next = nextGroup;
            pre = start;
            
        }

        return dummy.next;

    }

    //翻转从l...r的
    ListNode reverse(ListNode l, ListNode r) {
    ListNode pre = null, cur = l, nxt;
    while (cur != r) {
        nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
    }
    return pre;
}

}
