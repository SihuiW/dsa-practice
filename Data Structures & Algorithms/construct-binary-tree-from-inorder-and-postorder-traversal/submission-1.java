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
        Map<Integer, Integer> map = new HashMap<>();
        idx = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return f(postorder, map, 0, postorder.length - 1);
    }

    TreeNode f(int[] postorder, Map<Integer, Integer> map, int l, int r) {
        if(idx < 0 || l > r) return null;
        int rootVal = postorder[idx];
        TreeNode curNode = new TreeNode(rootVal);
        int curIdx = map.get(rootVal);
        idx--;

        curNode.right = f(postorder, map, curIdx + 1, r);
        curNode.left = f(postorder, map, l, curIdx - 1);
        return curNode;
    }
}