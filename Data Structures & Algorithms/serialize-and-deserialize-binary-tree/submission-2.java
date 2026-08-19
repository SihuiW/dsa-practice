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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.toString();
        dfsS(root, sb);
        return sb.toString();

    }

    void dfsS(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        dfsS(root.left,sb);
        dfsS(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] strs = data.split(",");
        index = 0;
        return dfsD(strs);
    }

    int index;

    TreeNode dfsD(String[] strs) {
        String cur = strs[index++];
        if(cur.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = dfsD(strs);
        node.right = dfsD(strs);
        return node;
    }
}
