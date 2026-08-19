class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int window = 0;
        int l = 0, r = 0;
        int res = Integer.MAX_VALUE;
        while(r < nums.length) {
            int c = nums[r];
            window += c;
            r++;
            while(window >= target) {
                res = Math.min(res, r - l);
                int d = nums[l];
                window -= d;
                l++;
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
}