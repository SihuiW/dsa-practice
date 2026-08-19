class Solution {
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        while(l < r) {
            while(l < r && !Character.isLetterOrDigit(cs[l])) l++;
            while(l < r && !Character.isLetterOrDigit(cs[r])) r--;
            if(l < r && Character.toLowerCase(cs[l]) != Character.toLowerCase(cs[r])) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}