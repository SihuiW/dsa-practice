/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {
 *     }
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (key == root.val) {
            if (l == null && r == null)
                return null;
            if (l != null && r != null) {
                TreeNode rep = findMin(r);
                root.val = rep.val;
                root.right = deleteNode(root.right, root.val);
                return root;
            }
            if (l != null) {
                return l;
            } else {
                return r;
            }
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode findMin(TreeNode node) {
        if (node == null)
            return null;
        if (node.left == null)
            return node;
        return findMin(node.left);
    }
}