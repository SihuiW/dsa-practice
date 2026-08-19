class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        while(l < r) {
            int water = heights[l] > heights[r] ? heights[r] * (r - l) : heights[l] * (r - l);
            res = Math.max(res, water);
            if(heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
