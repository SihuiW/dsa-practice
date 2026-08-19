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
            // 上一对的结尾
            ListNode end = pre;
            for(int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null) break;
            // 这一对的开始
            ListNode start = pre.next;
            // 下一对的开始
            ListNode nextGroup = end.next;
            // 反转这一对
            ListNode newHead = reverse(start, end.next);
            // 上一对的尾巴接上这一对的开始
            pre.next = newHead;
            // 这一对的结尾（此前的开始）接上下一对的开始
            start.next = nextGroup;
            // 这一对的尾巴是反转后的开始
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
