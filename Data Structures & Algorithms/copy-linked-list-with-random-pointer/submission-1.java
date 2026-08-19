/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while(p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        for(Map.Entry<Node,Node> entry: map.entrySet()) {
            Node ori = entry.getKey();
            Node newN = entry.getValue();
            newN.next = map.get(ori.next);
            newN.random = map.get(ori.random);
        }
        return map.get(head);
    }
}
