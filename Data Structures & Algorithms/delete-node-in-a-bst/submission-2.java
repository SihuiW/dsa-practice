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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if(key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(key == root.val) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            if(root.left != null && root.right != null) {
                TreeNode rep = f(root.right);
                root.val = rep.val;
                root.right = deleteNode(root.right, rep.val);
                return root;
            }
        }
        return root;
    }


    private TreeNode f(TreeNode root) {
        if(root == null) return null;
        if(root.left == null) return root;
        return f(root.left);
    }
}