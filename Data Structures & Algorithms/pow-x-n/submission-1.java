class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        long copy = n;
        if(copy < 0) {
            x = 1 / x;
            copy = -copy;
        }

        double res = 1;

        while(copy > 0) {
            if((copy & 1) == 1) {
                res *= x;
            }
            x *= x;
            copy >>>= 1;
        }

        return res;

    }
}
