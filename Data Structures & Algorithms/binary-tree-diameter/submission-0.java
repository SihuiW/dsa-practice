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
        return res - 1;
    }

    // 每次要返回这个节点左右最大的那个数给上面
    // 结果是左边最大+右边最大+node自己
    int f(TreeNode node) {
        if(node == null) return 0;
        int left = f(node.left);
        int right = f(node.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
