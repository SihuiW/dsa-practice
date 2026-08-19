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
    boolean hasPath;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        f(root, targetSum, 0);
        return hasPath;
    }

    void f(TreeNode root, int target, int sum) {
        if(root == null) return;
        sum += root.val;
        if(root.left == null && root.right == null && sum == target) {
            hasPath = true;
            return;
        }
        f(root.left, target, sum);
        f(root.right, target, sum);

    }
}