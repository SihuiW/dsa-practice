class Solution {
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    void dfs(TreeNode cur, int max) {
        if(cur == null) return;
        if(cur.val >= max) {
            res++;
            max = cur.val;
        }
        dfs(cur.left, max);
        dfs(cur.right, max);
    }
}