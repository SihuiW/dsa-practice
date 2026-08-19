class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int res = 0;
        int l = 0, r = 0;
        while(r < s.length()) {
            char c = s.charAt(r++);
            while(window.contains(c)) {
                char d = s.charAt(l++);
                window.remove(d);
            }
            window.add(c);
            res = Math.max(res, window.size());
        }
        return res;
    }
}
