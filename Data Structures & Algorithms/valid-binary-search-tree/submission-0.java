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

    int min;
    int max;


    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            return true;
        }
        boolean lb = isValidBST(root.left);
        int minL = min;
        int maxL = max;
        boolean rb = isValidBST(root.right);
        int minR = min;
        int maxR = max;
        min = Math.min(Math.min(minL,minR), root.val);
        max = Math.max(Math.max(maxL,maxR), root.val);
        return lb && rb && maxL < root.val && root.val < minR;

    }
}
