class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] arr = new int[m + n];
        for(int i = 0; i < n; i++) {
            arr[i] = nums1[i];
        }
        for(int i = 0, j = n; i < m; i++) {
            arr[j++] = nums2[i];
        }
        Arrays.sort(arr);
        if(arr.length % 2 == 0) {
            return (double)(arr[arr.length / 2] + arr[(arr.length / 2) - 1]) / 2;
        } else {
            return (double)arr[arr.length / 2];
        }
    }
}
