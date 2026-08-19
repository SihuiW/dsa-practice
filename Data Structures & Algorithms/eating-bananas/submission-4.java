class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for(int pile: piles) {
            r = Math.max(r, pile);
        }

        int l = 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(f(piles, mid) > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;

    }

    int f(int[] piles, int speed) {
        int res = 0;
        for(int p: piles) {
            if(p <= speed) {
                res++;
            } else {
                res += Math.ceil((double)p / speed);
            }
        }
        return res;
    }
}
