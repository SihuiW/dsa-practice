class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int window = 0;
        int l = 0, r = 0;
        int res = 0;
        while(r < arr.length) {
            window += arr[r];
            r++;
            if(r - l == k) {
                int ava = window / k;
                if(ava >= threshold) {
                    res++;
                }
                window -= arr[l];
                l++;
            }
        }
        return res;
    }
}