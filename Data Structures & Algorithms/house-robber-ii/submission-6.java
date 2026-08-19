class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int a = f(nums, 0, nums.length - 2);
        int b = f(nums, 1, nums.length - 1);
        return Math.max(a, b);
    }

    public int f(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(dp[0], nums[start + 1]);
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start]);
        }
        return dp[dp.length - 1];
    }
}
