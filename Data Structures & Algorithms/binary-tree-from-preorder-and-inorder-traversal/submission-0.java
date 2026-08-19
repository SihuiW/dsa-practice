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
    Map<Integer, Integer> map = new HashMap<>();
    int rootIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0,inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int il, int ir) {
        if(il > ir) return null;
        int val = preorder[rootIndex];
        rootIndex++;
        int index = map.get(val);
        TreeNode node = new TreeNode(val);
        node.left = build(preorder,inorder,il,index - 1);
        node.right = build(preorder,inorder,index + 1, ir);
        return node;

    }
}
