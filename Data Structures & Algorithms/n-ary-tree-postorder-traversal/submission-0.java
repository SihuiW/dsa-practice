/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        f(root, res);
        return res;
    }

    void f(Node root, List<Integer> list) {
        if(root == null) return;
        
        for(Node c: root.children) {
            f(c, list);
        }
        list.add(root.val);
    }
}