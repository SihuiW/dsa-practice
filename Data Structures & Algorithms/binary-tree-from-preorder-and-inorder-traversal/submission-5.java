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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return f(preorder, map, 0, inorder.length - 1);
    }

    TreeNode f(int[] preorder, Map<Integer, Integer> map, int l, int r) {
        if (idx >= preorder.length || l > r)
            return null;
        
        int val = preorder[idx++];
        TreeNode curNode = new TreeNode(val);
        int cur = map.get(val);

        curNode.left = f(preorder, map, l, cur - 1);
        curNode.right = f(preorder, map, cur + 1, r);
        
        return curNode;
    }
}
