class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            int odd = f(s, i, i);
            int even = f(s, i, i + 1);
            res += odd + even;
        }
        return res;
    }

    int f(String s, int start, int end) {
        int res = 0;
        while(start >= 0 && end < s.length()) {
            if(s.charAt(start) == s.charAt(end)) {
                res++;
                start--;
                end++;
            } else {
                break;
            }
        }
        return res;
    }
}
