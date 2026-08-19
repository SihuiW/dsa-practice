class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0, r = 0;
        int sum = 0;
        int res = 0;
        while(r < arr.length) {
            sum += arr[r];
            if(r - l + 1 == k) {
                if(sum / k >= threshold) res++;
                sum -= arr[l++];
            }
            r++;
        }
        return res;
    }
}