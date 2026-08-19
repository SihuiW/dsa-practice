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
        if(idx >= data.length()) return null;
        int val = 0;
        char c = data.charAt(idx);
        if(c == '#') {
            idx++;
            return null;
        }
        while(data.charAt(idx) != ',') {
            val = val * 10 + (data.charAt(idx) - '0');
            idx++;
        }
        idx++;
        TreeNode cur = new TreeNode(val);
        cur.left = deserialize(data);
        cur.right = deserialize(data);
        return cur;
    }

    void dfs(TreeNode root) {
        if(root == null) {
            sb.append("#");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left);
        dfs(root.right);

    }
}
