class Solution {
    public int trap(int[] height) {
        int res = 0;
        for(int i = 1; i < height.length - 1; i++) {
            int h = height[i];
            int leftMax = 0, rightMax = 0;
            for(int l = 0; l < i; l++) {
                leftMax = Math.max(leftMax, height[l]);
            }
            for(int r = i + 1; r < height.length; r++) {
                rightMax = Math.max(rightMax, height[r]);
            }
            if(leftMax > h && rightMax > h) {
                res += Math.min(leftMax, rightMax) - h;
            }
        }
        return res;
    }
}
