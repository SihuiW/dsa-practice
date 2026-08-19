class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String odd = f(s, i, i);
            String even = f(s, i, i + 1);
            String longer = odd.length() > even.length()? odd: even;
            res = longer.length() > res.length() ? longer: res;
        }
        return res;
    }

    String f(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left  + 1, right);
        
    }
}
