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
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return f(postorder, map, 0, postorder.length - 1);
    }

    private TreeNode f(int[] postorder, Map<Integer, Integer> map, int l, int r) {
        if(l > r) return null;
        int val = postorder[idx];
        TreeNode node = new TreeNode(val);
        idx--;
        node.right = f(postorder, map, map.get(val) + 1, r);
        node.left = f(postorder, map, l, map.get(val) - 1);
        return node;
    }
}
















