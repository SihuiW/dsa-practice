class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int pile: piles) {
            r = Math.max(r, pile);
        } 
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(f(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean f(int[] piles, int mid, int h) {
        int hours = 0;
        for(int pile: piles) {
            hours = hours + (pile + mid - 1) / mid;

            if(hours > h) return false;
        }
        return true;
    }
}
