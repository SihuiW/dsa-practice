class Solution {
    public int characterReplacement(String s, int k) {
        int[] window = new int[26];
        int l = 0, r = 0, freqNum = 0;
        int res = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            window[c - 'A']++;
            freqNum = Math.max(window[c - 'A'], freqNum);
            r++;
            while(r - l - freqNum > k) {
                char d = s.charAt(l);
                window[d - 'A']--;
                l++;
            }
            res = Math.max(res, r - l);
            
        }
        return res;
    }
}
