class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for(int w: weights) {
            r += w;
            l = Math.max(l, w);
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
        int days = 1;
        int sum = 0;
        for(int w: weights) {
            if(sum + w > c) {
                days++;
                sum = w;
            } else {
                sum += w;
            }
        }
        return days;
    }
}