class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int res = 0;
        while(l < r) {
            int h = Math.min(heights[l], heights[r]);
            int water = h * (r - l);
            res = Math.max(res, water);
            if(h == heights[l]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
