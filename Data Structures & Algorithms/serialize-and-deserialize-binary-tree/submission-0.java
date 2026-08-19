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
        f1(root, sb);
        return sb.toString();

    }

    void f1(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        f1(root.left,sb);
        f1(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] strs = data.split(",");
        index = 0;
        return f2(strs);
    }

    int index;

    TreeNode f2(String[] strs) {
        String cur = strs[index++];
        if(cur.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = f2(strs);
        node.right = f2(strs);
        return node;
    }
}
