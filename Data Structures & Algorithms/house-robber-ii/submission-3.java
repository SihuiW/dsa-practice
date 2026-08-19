class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int a = f(nums, 0, nums.length - 2);
        int b = f(nums, 1, nums.length - 1);

        return Math.max(a,b);
    }

    int f(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
