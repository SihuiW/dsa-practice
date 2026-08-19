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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode preLeft = null;
        ListNode rightNode = null;
        for(int i = 0; i <= right; i++) {
            if(i == left - 1) {
                preLeft = p;
            }
            if(i == right) {
                rightNode = p;
            }
            p = p.next;
        }
        ListNode leftNode = preLeft.next;
        preLeft.next = null;
        ListNode nextRight = rightNode.next;
        rightNode.next = null;
        
        ListNode pre = null;
        ListNode cur = leftNode;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        preLeft.next = pre;
        leftNode.next = nextRight;
        return dummy.next;
    }
}