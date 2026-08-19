class Solution {
    public int characterReplacement(String s, int k) {
        int[] window = new int[26];
        int maxFreq = 0;
        int res = 0;
        int l = 0, r = 0;
        while(r < s.length()) {
            char c = s.charAt(r++);
            window[c - 'A']++;
            maxFreq = Math.max(maxFreq, window[c - 'A']);
            while(r - l - maxFreq > k) {
                window[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
