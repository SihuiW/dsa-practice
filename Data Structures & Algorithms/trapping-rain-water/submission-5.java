class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lh = new int[n];
        int[] rh = new int[n];
        lh[0] = height[0];
        rh[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++) {
            lh[i] = Math.max(lh[i - 1], height[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            rh[i] = Math.max(rh[i + 1], height[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            int water = Math.min(lh[i], rh[i]) - height[i];
            res += water;
        }
        return res;
    }
}
