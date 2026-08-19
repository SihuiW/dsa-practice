class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        StringBuilder window = new StringBuilder();
        int left = 0, right = 0;
        while(right < s.length()) {
            window.append(s.charAt(right));
            right++;
            res = Math.max(res, window.length());
            while(right < s.length() && window.toString().contains(s.charAt(right) + "")) {
                window.deleteCharAt(0);
            }
        }
        return res;
    }
}
