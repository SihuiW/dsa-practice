class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1;
        for(int n: piles) {
            r = Math.max(n, r);
        }
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(f(piles, mid) <= h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    int f(int[] piles, int k) {
        int res = 0;
        for(int p: piles) {
            res += Math.ceil((p + k - 1) / k);
        }
        return res;
    }
}
