class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int len = 1;
        int prev = 0;

        for (int i = 1; i < arr.length; i++) {
            int cur = Integer.compare(arr[i], arr[i - 1]);

            if (cur == 0) {
                len = 1;
            } else if (cur * prev == -1) {
                len++;

            } else {
                len = 2;
            }

            res = Math.max(res, len);
            prev = cur;
        }

        return res;
    }
}