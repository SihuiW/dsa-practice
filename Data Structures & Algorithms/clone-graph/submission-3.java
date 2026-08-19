/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        f(node, map);
        for(Map.Entry<Node, Node> entry: map.entrySet()) {
            Node oldN = entry.getKey();
            Node newN = entry.getValue();
            for(Node nei: oldN.neighbors) {
                newN.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }

    void f(Node node, Map<Node, Node> map) {
        if(node == null || map.containsKey(node)) return;
        map.put(node, new Node(node.val));
        for(Node n: node.neighbors) {
            f(n, map);
        }
    }
}