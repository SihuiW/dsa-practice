class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if((long)m * m <= x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}