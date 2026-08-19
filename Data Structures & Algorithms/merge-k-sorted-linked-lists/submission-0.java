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
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node: lists) {
            pq.offer(node);
        }
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            ListNode p2 = node;
            if(p2.next != null) {
                pq.offer(p2.next);
            }
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }
}
