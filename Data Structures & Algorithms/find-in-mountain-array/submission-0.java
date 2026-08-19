/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        // find peak
        int l = 1, r = length - 2, peak = 0;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int left = mountainArr.get(m - 1);
            int right = mountainArr.get(m + 1);
            int mid = mountainArr.get(m);

            if(mid > left && mid < right) {
                l = m + 1;
            } else if(mid < left && mid > right) {
                r = m - 1;
            } else {
                peak = m;
                break;
            }

        }

        // search left
        l = 0;
        r = peak - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);
            if(target == val) {
                return m;
            } else if (target > val) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        } 

        // search right
        l = peak;
        r = length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);
            if(target == val) {
                return m;
            } else if (target > val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}