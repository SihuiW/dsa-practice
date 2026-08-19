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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node: lists) {
            if (node != null) pq.offer(node);
        }
        while (!pq.isEmpty()) {
            ListNode pre = pq.poll();
            p.next = pre;
            p = p.next;
            if (pre.next != null) pq.add(pre.next);
        }
        return dummy.next;
    }
}
