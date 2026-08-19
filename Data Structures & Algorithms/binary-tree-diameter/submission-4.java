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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return res;
    }

    private int f(TreeNode root) {
        if(root == null) return 0;
        int l = f(root.left);
        int r = f(root.right);
        res = Math.max(res, l + r);
        return Math.max(l, r) + 1;
    }
}
