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
        if(!dfs(cur.left)) return false;
        if(pre != null && cur.val <= pre.val) return false;
        pre = cur;
        return dfs(cur.right);
    }
}
