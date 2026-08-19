class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for(int w: weights) {
            l = Math.max(l, w);
            r += w; 
        }

        while(l <= r) {
            int m = l + (r - l) / 2;
            if(f(weights, m) <= days) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    int f(int[] weights, int c) {
        int res = 1;
        int ship = 0;
        for(int w: weights) {
            if(ship + w > c) {
                res++;
                ship = w;
            } else {
                ship += w;
            }
        }
        return res;
    }
}