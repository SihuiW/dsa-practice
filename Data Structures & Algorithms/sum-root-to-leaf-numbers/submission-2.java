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
    public int sumNumbers(TreeNode root) {
        f(root,0);
        return res;
    }

    void f(TreeNode root, int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            sum = sum * 10 + root.val;
            res += sum;
            return;   
        }
        sum = sum * 10 + root.val;
        f(root.left, sum);
        f(root.right, sum);
    }
}