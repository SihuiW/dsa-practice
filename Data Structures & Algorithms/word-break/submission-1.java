class Solution {
    private Boolean[] memo;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        memo = new Boolean[s.length()]; // 为什么长度是 s.length()？
        return backtrack(s, 0, dict);
    }

    private boolean backtrack(String s, int start, Set<String> dict) {
        if (start == s.length()) return true;
        
        // TODO: 在这里添加缓存检查
        // 如果 memo[start] 已经计算过，直接返回
        if(memo[start] != null) return memo[start];
        
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            
            if (dict.contains(word) && backtrack(s, end, dict)) {
                // TODO: 在这里记录结果到 memo[start]
                memo[start] = true;
                return true;
            }
        }
        
        // TODO: 所有尝试都失败，记录到 memo[start]
        memo[start] = false;
        return false;
    }
}