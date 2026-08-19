class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> window = new HashSet<>();
        int l = 0, r = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            while(window.contains(c)) {
                char d = s.charAt(l);
                window.remove(d);
                l++;
            }
            window.add(c);
            r++;
            res = Math.max(res, window.size());
        }
        return res;
    }
}

