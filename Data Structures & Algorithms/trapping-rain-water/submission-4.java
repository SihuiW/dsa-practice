class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] LMAX = new int[n];
        int[] RMAX = new int[n];
        LMAX[0] = height[0];
        RMAX[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++) {
            LMAX[i] = Math.max(LMAX[i - 1], height[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            RMAX[i] = Math.max(RMAX[i + 1], height[i]);
        }
        int res = 0;
        for(int i = 1; i < n - 1; i++) {
            int area = Math.min(LMAX[i], RMAX[i]) - height[i];
            res += area;
        }
        return res;
    }
}