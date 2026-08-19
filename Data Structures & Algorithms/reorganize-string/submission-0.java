class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        char maxChar = ' ';
        int maxCount = 0;
        
        // 统计频率，顺便找最大频率的字符
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > maxCount) {
                maxCount = count[c - 'a'];
                maxChar = c;
            }
        }
        
        // 不可能的情况
        if (maxCount > (n + 1) / 2) {
            return "";
        }
        
        char[] res = new char[n];
        int idx = 0;
        
        // 先放最高频率的字符到偶数位置
        for (int i = 0; i < maxCount; i++) {
            res[idx] = maxChar;
            idx += 2;
        }
        
        // 最高频率的已经用完
        count[maxChar - 'a'] = 0;
        
        // 继续填剩余字符（从当前idx开始，超出时切换到奇数位置）
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (idx >= n) {
                    idx = 1;  // 切换到奇数位置
                }
                res[idx] = (char) (i + 'a');
                count[i]--;
                idx += 2;
            }
        }
        
        return new String(res);
    }
}