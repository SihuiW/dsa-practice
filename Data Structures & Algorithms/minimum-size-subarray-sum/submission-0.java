class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int window = 0;
        int left = 0, right = 0;
        while(right < nums.length) {
            window += nums[right];
            right++;
            while(window >= target) {
                res = Math.min(res, (right - left));
                window -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0: res;
    }
}