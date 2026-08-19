class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int w: weights) {
            max = Math.max(max, w);
            sum += w;
        }

        int l = max, r = sum;
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

    private int f(int[] weights, int cap) {
        int cnt = 1;
        int convey = 0;
        for(int w: weights) {
            if (convey + w > cap) {
                cnt++;
                convey = 0;
            }
            convey += w;
        }
        return cnt;
    }
}