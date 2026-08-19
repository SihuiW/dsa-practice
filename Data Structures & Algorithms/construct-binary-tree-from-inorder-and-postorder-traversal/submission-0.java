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
        int n = inorder.length;
        for(int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        idx = n - 1;
        return f(map, postorder, 0, n - 1);
    }

    TreeNode f(Map<Integer, Integer> map, int[] postorder, int il, int ir) {
        if(il > ir) return null;
        int val = postorder[idx--];
        int i = map.get(val);
        TreeNode node = new TreeNode(val);
        
        node.right = f(map, postorder,i + 1, ir);
        node.left = f(map, postorder,il, i - 1);
        return node;
    }
}