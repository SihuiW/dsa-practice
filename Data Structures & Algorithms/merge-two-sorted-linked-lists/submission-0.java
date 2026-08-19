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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = list1, p2 = list2, p3 = dummy;
        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        if(p1 != null) {
            p3.next = p1;
        }
        if(p2 != null) {
            p3.next = p2;
        }

        return dummy.next;
    }
}