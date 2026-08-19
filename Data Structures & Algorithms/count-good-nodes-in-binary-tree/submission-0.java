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
        f(root, -101);
        return res;
    }

    void f(TreeNode node, int max) {
        if(node == null) return;
        int val = node.val;
        if(val >= max) {
            res++;
            max = val;
        }
        f(node.left, max);
        f(node.right, max);

    }
}
