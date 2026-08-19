class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for(char c: s.toCharArray()) {
            map[c]++;
        }
        int max = 0;
        int even = 0;
        for(int m: map) {
            if(m % 2 == 0) {
                max += m;
            } else {
                max += (m - 1);
            }
            if(even == 0) {
                if(m % 2 != 0) {
                    even = 1;
                }
            }
        }
        return max + even;
    }
}