class Solution {
    public int characterReplacement(String s, int k) {
        int[] window = new int[26];
        int res = 0, freqNum = 0, l = 0, r = 0;
        while(r < s.length()) {
            int c  = s.charAt(r) - 'A';
            r++;
            window[c]++;
            freqNum = Math.max(window[c], freqNum);
            while(r - l - freqNum > k) {
                window[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
