class Solution {
    double closet = 0;
    public int closestValue(TreeNode root, double target) {
        closet = root.val;
        f(root, target);
        return (int) closet;
    }

    void f(TreeNode root, double target) {
        if (root == null) return;
        if(root.val == target) {
            closet = root.val;
            return;
        }
        if(Math.abs(root.val - target) <= Math.abs(closet - target)) {
            closet = root.val;
        }
        if(root.val > target) {
            f(root.left, target);
        } else {
            f(root.right, target);
        }
    }
}