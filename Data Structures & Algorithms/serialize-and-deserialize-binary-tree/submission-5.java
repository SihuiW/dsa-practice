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

public class Codec {

    StringBuilder sb = new StringBuilder();
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        idx = 0;
        return f(strs);
    }

    TreeNode f(String[] data) {
        if(data[idx].equals("#")) {
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(data[idx]));
        idx++;
        node.left = f(data);
        node.right = f(data);
        return node;
    }

    void dfs(TreeNode root) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left);
        dfs(root.right);

    }
}
