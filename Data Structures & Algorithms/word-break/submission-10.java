class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String w: wordDict) set.add(w);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = dp[i] || (dp[j] && set.contains(s.substring(j, i)));
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
