class Solution {
    public int tripletCount(int[] a, int[] b, int[] c) {
        int res = 0;

        for (int x : a) {
            for (int y : b) {
                for (int z : c) {
                    int n = x ^ y ^ z;
                    if (Integer.bitCount(n) % 2 == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}