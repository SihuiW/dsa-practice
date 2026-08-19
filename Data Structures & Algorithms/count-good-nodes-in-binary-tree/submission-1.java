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
    public int goodNodes(TreeNode root) {
        dfs(root, -101);
        return res;
    }

    void dfs(TreeNode root, int max) {
        if(root == null) return;
        int val = root.val;
        if(val >= max) {
            max = val;
            res++;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
