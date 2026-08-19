class Solution {
    // 把wordDict放进hashset里面用于判断字串是否存在
    // 从0开始找字串 如果字串存在 那么就从下一个index开始找后面的部分存不存在
    // 但是这里可能会存在appl不可以 但apple后面就可以 所以存在可以直接返回true
    // 但如果不存在 也不能直接返回false 需要回溯
    // 但很有可能重复调用多次，所以需要一个memo记录当前index开始的字串的结果
    // memo需要记录 null 存在 不存在
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        Set<String> dict = new HashSet<>();
        for(String word: wordDict) {
            dict.add(word);
        }
        return f(s, 0, dict, memo);
    }

    boolean f(String s, int index, Set dict, Boolean[] memo) {
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
