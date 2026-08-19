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
    // 记录这棵树上最大路径的
    int max = -1000;
    public int maxPathSum(TreeNode root) {
        subMax(root);
        return max;
    }

    public int subMax(TreeNode root) {
        if(root == null) return 0;
        int rootVal = root.val;
        int lm = Math.max(0,subMax(root.left));
        int rm = Math.max(0,subMax(root.right));
        max = Math.max(max,rm + lm + rootVal);
        return Math.max(lm,rm) + rootVal;
    }
}
