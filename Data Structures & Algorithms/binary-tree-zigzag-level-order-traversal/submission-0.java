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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        boolean odd = false;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while(!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> list = new ArrayDeque<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(odd) {
                    list.offerFirst(cur.val);
                } else {
                    list.offerLast(cur.val);
                }
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(new ArrayList<>(list));
            odd = !odd;
        }
        return res;
    }
}