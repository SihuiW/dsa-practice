class Solution {
    public int characterReplacement(String s, int k) {
        int[] window = new int[26];
        int maxFreq = 0;
        int l = 0, r = 0;
        int res = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            window[c - 'A']++;
            maxFreq = Math.max(maxFreq, window[c - 'A']);
            while(r - l + 1 - maxFreq > k) {
                char d = s.charAt(l++);
                window[d - 'A']--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}