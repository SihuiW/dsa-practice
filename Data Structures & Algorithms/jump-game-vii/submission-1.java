class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for(int i = 1; i < s.length(); i++) {
            for(int j = Math.max(0, i - maxJump); j <= i - minJump; j++) {
                if(dp[j] && s.charAt(i) == '0') {
                    dp[i] = true;
                }
            }
            
        }
        return dp[s.length() - 1];
    }
}