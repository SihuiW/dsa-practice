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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        f(root);
        return res;
    }

    int f(TreeNode node) {
        if(node == null) {
            return -1;
        }

        int leftH = f(node.left);
        int rightH = f(node.right);
        int height = Math.max(leftH, rightH) + 1;

        if(res.size() == height){
            res.add(new ArrayList<>());
        }

        res.get(height).add(node.val);
        return height;
    }
}
