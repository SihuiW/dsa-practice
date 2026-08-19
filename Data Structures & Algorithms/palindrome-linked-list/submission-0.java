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
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        while(p != null) {
            sb.append(p.val);
            p = p.next;
        }
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        return s1.equals(s2);
    }
}