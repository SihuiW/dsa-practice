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
    int index = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,inorder.length - 1);
    }

    TreeNode build(int[] preorder,int[] inorder, int il, int ir) {
        if(il > ir) return null;
        int val = preorder[index++];
        int i = map.get(val);
        TreeNode node = new TreeNode(val);
        node.left = build(preorder, inorder, il, i - 1);
        node.right = build(preorder, inorder, i + 1, ir);
        return node;
    }
}
