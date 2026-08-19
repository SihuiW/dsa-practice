class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        int res = 0, l = 0, r = 0;
        while(r < s.length()) {
            int c = s.charAt(r);
            window[c]++;
            r++;
            while(window[c] > 1) {
                int d = s.charAt(l);
                window[d]--;
                l++;
            }
            res = Math.max(res, r-l);
        }
        return res;
    }
}
