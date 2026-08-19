class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        
        for(int i = 0; i < s.length(); i++) {
            String a = f(s,i,i);
            String b = f(s,i,i+1);
            String longer = a.length() > b.length()? a: b;
            res = longer.length() > res.length() ? longer: res;
        }

        return res;
        
    }

    String f(String s, int start, int end) {
        while(start >= 0 && end < s.length()) {
            if(s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
