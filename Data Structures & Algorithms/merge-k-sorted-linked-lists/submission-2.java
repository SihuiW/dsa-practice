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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for(ListNode node: lists) {
            pq.offer(node);
        }

        while(!pq.isEmpty()) {
            ListNode cur = pq.poll();
            p.next = cur;
            p = p.next;
            if(cur.next != null) pq.offer(cur.next);
        }

        return dummy.next;
    }
}
