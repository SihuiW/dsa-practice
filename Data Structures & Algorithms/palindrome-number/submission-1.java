class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 9) return true;
        String n = x + "";
        int l = 0, r = n.length() - 1;
        while(l < r) {
            if(n.charAt(l) != n.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}