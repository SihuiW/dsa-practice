class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    
    dp[n] = true;  // base case是什么？
    
    // 从后往前填表
    for (int i = n - 1; i >= 0; i--) {
        // 尝试从i开始的所有可能子串
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
