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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        if (same(root, subRoot))
            return true;
        boolean l = isSubtree(root.left, subRoot);
        boolean r = isSubtree(root.right, subRoot);
        return l || r;
    }

    boolean same(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        if (root.val != subRoot.val)
            return false;
        return same(root.left, subRoot.left) && same(root.right, subRoot.right);
    }
}
