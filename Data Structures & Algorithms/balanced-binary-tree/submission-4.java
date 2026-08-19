/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (f(root) == -1)
            return false;
        return true;
    }

    private int f(TreeNode node) {
        if (node == null)
            return 0;
        int l = f(node.left);
        int r = f(node.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;
        return Math.max(l, r) + 1;
    }
}