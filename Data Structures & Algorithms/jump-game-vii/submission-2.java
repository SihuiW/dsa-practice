class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        if (s.charAt(n - 1) == '1') {
            return false;
        }
        dp[0] = true;
        for(int i = 1; i < n; i++) {
            int start = Math.max(0, i - maxJump);
            if(s.charAt(i) == '1') {
                dp[i] = false;
                continue;
            }
            int left = Math.max(0, i - maxJump);
            int right = i - minJump;
            
            if (right < 0) {
                dp[i] = false;
                continue;
            }
            
            for (int j = left; j <= right; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[n - 1];
    }
}