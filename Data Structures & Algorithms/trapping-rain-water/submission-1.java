class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int[] lm = new int[n];
        int[] rm = new int[n];

        lm[0] = height[0];
        rm[n - 1] = height[n - 1];

        for(int l = 1; l < n; l++) {
            lm[l] = Math.max(lm[l - 1], height[l]);
        }
        for(int r = n - 2; r > 0; r--) {
            rm[r] = Math.max(rm[r + 1], height[r]);
        }

        for(int i = 0; i < n; i++) {
            int water = Math.min(lm[i], rm[i]) - height[i];
            if(water > 0) res += water;
        }

        return res;
    }
}
