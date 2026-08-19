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

    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);

    }

    boolean dfs(TreeNode cur) {
        if(cur == null) return true;
        boolean l = dfs(cur.left);
        if(pre != null && cur.val <= pre.val) return false;
        pre = cur;
        boolean r = dfs(cur.right);
        return l && r;
    }
}
