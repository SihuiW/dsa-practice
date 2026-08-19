class Solution {
    // 找到总和total
    // 找到每一个子集的和sum 看看sum是否是二分之一的total
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int n: nums) {
            total += n;
        }
        if(total % 2 != 0) return false;
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int n: nums) {
            for(int j = target; j >= n; j--) {
                dp[j] = dp[j] || dp[j - n];
            }
        }
        
        return dp[target];
    }
}
