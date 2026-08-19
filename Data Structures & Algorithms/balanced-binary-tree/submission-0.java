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
    boolean isHB = true;
    public boolean isBalanced(TreeNode root) {
        f(root);
        return isHB;
    }

    // 树的高度
    int f(TreeNode node) {
        if(node == null) return 0;
        int left = f(node.left);
        int right = f(node.right);
        if(Math.abs(left - right) > 1) {
            isHB = false;
        }
        return Math.max(left, right) + 1;
    }
    


}
