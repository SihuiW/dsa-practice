class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int p: piles) r = Math.max(r, p);
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(f(piles, m) <= h) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int f(int[] piles, int k) {
        int res = 0;
        for(int p: piles) {
            res += (p + k - 1) / k;
        }
        return res;
    }
}
