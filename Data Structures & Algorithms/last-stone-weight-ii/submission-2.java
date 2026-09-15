class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int s: stones) {
            total += s;
        }
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int s: stones) {
            for(int i = target; i >= s; i--) {
                dp[i] = dp[i] || dp[i - s];
            }
        }
        int v = 0;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i]) v = i;
        }
        return Math.abs(total - v - v);
    }
}