class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for(int i = 0; i <= m - n; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int l = i + 1, r = 1;
                int valid = 1;
                while(l < m && r < n && haystack.charAt(l) == needle.charAt(r)) {
                    valid++;
                    l++;
                    r++;
                }
                if (valid == n) return i;
            }
        }
        return -1;
    }
}