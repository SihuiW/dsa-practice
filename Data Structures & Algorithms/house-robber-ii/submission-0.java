class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int a = f(nums, 0, nums.length - 2);
        int b = f(nums, 1, nums.length - 1);
        return Math.max(a,b);
    }

    int f(int[] nums, int l, int r) {
        int[] dp = new int[r - l + 1];
        dp[0] = nums[l];
        dp[1] = Math.max(nums[l], nums[l + 1]);
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[l + i]);
        }
        return dp[dp.length - 1];
    }
}
