class Solution {
    public int climbStairs(int n) {
        int lastlast = 1;
        int last = 1;
        for(int i = 2; i <= n; i++) {
            int cur = last + lastlast;
            lastlast = last;
            last =  cur;
        }
        return last;
    }
}
