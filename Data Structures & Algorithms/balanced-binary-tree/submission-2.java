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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int l = f(root.left);
        int r = f(root.right);
        return Math.abs(l - r) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    int f(TreeNode node) {
        if(node == null) return 0;
        return Math.max(f(node.left), f(node.right)) + 1;
    }
}
