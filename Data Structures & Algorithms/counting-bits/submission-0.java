class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            res[i] = f(i);
        }
        return res;
    }

    int f(int i) {
        int num = 0;
        while(i != 0) {
            num += (i & 1);
            i >>= 1;
        }
        return num;
    }
}
