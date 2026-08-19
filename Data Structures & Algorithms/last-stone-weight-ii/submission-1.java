class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int s: stones) total += s;
        int half = total / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for(int s: stones) {
            for(int i = half; i >= s; i--) {
                dp[i] = dp[i] || dp[i - s];
            }
        }
        int res = 0;
        for(int i = half; i >= 0; i--) {
            if(dp[i]) {
                res = Math.abs(total - i - i);
                break;
            }
        } 
        return res;
    }
}