class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = m + n;
        int half = (total + 1) / 2;
        
        int l = 0, r = n;
        while(l <= r) {
            int j = l + (r - l) / 2;
            int i = half - j;

            int left1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = i < m? nums1[i] : Integer.MAX_VALUE;
            int left2 = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = j < n? nums2[j] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1) {
                if(total % 2 != 0) {
                    return Math.max(left1, left2);
                }
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                l = j + 1;
            } else {
                r = j - 1;
            }
        }
        
        return -1;
    }
}