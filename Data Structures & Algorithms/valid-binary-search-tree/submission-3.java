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
    public boolean isValidBST(TreeNode root) {
        return f(root, -1000, 1000);
    }

    boolean f(TreeNode root, int left, int right) {
        if(root == null) return true;
        if(!(left < root.val && root.val < right)) return false;
        return f(root.left, left, root.val) && f(root.right, root.val, right);
    }
}
