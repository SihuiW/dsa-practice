/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    List<Integer> list = new ArrayList<>();
    int idx = 0;

    public BSTIterator(TreeNode root) {
        f(root);
    }
    
    public int next() {
        if(!hasNext()) return -1;
        return list.get(idx++);
    }
    
    public boolean hasNext() {
        return idx < list.size();
    }

    private void f(TreeNode root) {
        if(root == null) return;
        f(root.left);
        list.add(root.val);
        f(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */