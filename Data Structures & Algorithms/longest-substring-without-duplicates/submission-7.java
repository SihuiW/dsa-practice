class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        char[] arr = s.toCharArray();
        int res = 0;
        while(r < arr.length) {
            char c = arr[r];
            while(l < r && set.contains(c)) {
                char d = arr[l];
                set.remove(d);
                l++;
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
