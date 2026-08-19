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
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return sb.toString();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur == null) {
                    sb.append("null,");
                } else {
                    sb.append(cur.val + ",");
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
        }
        return sb.toString();
    }

    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index++]));
        q.add(root);
        while(!q.isEmpty() && index < nodes.length) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(!nodes[index].equals("null")) {
                    cur.left = new TreeNode(Integer.valueOf(nodes[index++]));
                    q.add(cur.left);
                } else {
                    index++;
                } 
                if(!nodes[index].equals("null")) {
                    cur.right = new TreeNode(Integer.valueOf(nodes[index++]));
                    q.add(cur.right);
                } else {
                    index++;
                }
            }
           
            
        }
        return root;
    }
}
