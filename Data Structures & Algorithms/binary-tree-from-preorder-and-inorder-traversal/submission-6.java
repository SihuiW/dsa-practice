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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return f(preorder, map, 0, inorder.length - 1);
    }

    TreeNode f(int[] preorder, Map<Integer, Integer> map, int l, int r) {
        if(l > r) return null;
        int cur = preorder[idx];
        TreeNode node = new TreeNode(cur);
        idx++;
        node.left = f(preorder, map, l, map.get(cur) - 1);
        node.right = f(preorder, map, map.get(cur) + 1, r);
        return node;
    }
}













