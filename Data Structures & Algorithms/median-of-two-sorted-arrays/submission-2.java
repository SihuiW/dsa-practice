class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int p1 = 0, p2 = 0, p3 = 0;
        while(p1 < m && p2 < n) {
            if(nums1[p1] < nums2[p2]) {
                arr[p3++] = nums1[p1++];
            } else {
                arr[p3++] = nums2[p2++];
            }
        }

        while(p1 < m) {
            arr[p3++] = nums1[p1++];
        }
        
        while(p2 < n) {
            arr[p3++] = nums2[p2++];
        }

        if(arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        }
        return (double)arr[arr.length / 2];
    }
}