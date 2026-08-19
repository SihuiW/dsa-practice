class Solution {
    /**
    * 单词拆分问题 - 使用回溯 + 记忆化搜索
    * 
    * 核心思路：
    * 1. 将wordDict转为HashSet，实现O(1)时间复杂度的查找
    * 2. 从索引0开始，尝试匹配不同长度的子串
    * 3. 如果子串在字典中，递归检查剩余部分能否被拆分
    * 4. 使用for循环实现回溯：如果某个子串后续失败，自动尝试更长的子串
    * 5. 使用memo数组避免重复计算：memo[i]表示从索引i开始的子串能否被拆分
    * 
    * memo数组的三种状态：
    * - null: 未计算过
    * - true: 从该位置开始可以拆分
    * - false: 从该位置开始无法拆分
    * 
    * 时间复杂度：O(n^2 * m)，其中n是字符串长度，m是平均单词长度
    * 空间复杂度：O(n) memo数组 + O(n) 递归栈
    */

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        Set<String> dict = new HashSet<>();
        for(String word: wordDict) {
            dict.add(word);
        }
        return f(s, 0, dict, memo);
    }

    boolean f(String s, int index, Set<String> dict, Boolean[] memo) {
        if(index == s.length()) return true;
        if(memo[index] != null) return memo[index];
        for(int end = index + 1; end <= s.length(); end++) {
            String sub = s.substring(index, end);
            if(dict.contains(sub)) {
                if(f(s, end, dict, memo)){
                    memo[index] = true;
                    return true;
                }
            }
        }
        memo[index] = false;
        return false;
    }
}
