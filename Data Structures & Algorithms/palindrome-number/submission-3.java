class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int originalX = x;
        long rx = 0;
        while(x != 0) {
            int n = x % 10;
            rx = rx * 10 + n;
            x /= 10;
        }
        return rx == originalX;
    }
}