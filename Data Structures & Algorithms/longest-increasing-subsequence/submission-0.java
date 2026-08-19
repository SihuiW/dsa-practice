class Solution {
    //dp[i...n] 以i为起点的严格递增子序列最大长度
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = n - 2; i >= 0; i--) {
            // dpi依赖于dp[i+1]
            for(int j = i + 1; j < n; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
