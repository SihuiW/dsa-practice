class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        
        dp[n] = true;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int end = i + 1; end <= n; end++) {
                String sub = s.substring(i, end);
                if (dict.contains(sub) && dp[end]) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[0];
    }
}
