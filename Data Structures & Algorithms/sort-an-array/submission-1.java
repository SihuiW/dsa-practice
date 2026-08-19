class Solution {
    public int[] sortArray(int[] nums) {
        f(nums, 0, nums.length - 1);
        return nums;
    }

    void f(int[] nums, int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        f(nums, start, mid);
        f(nums, mid + 1, end);
        merge(nums, start, end, mid);
    }
    
    void merge(int[] nums, int start, int end, int mid) {
        int[] res = new int[end - start + 1];
        int p1 = start, p2 = mid + 1, p = 0;
        while(p1 <= mid && p2 <= end) {
            if(nums[p1] <= nums[p2]) {
                res[p] = nums[p1];
                p1++;
            } else {
                res[p] = nums[p2];
                p2++;
            }
            p++;
        }
        while(p1 <= mid) {
            res[p++] = nums[p1++];
        }
        while(p2 <= end) {
            res[p++] = nums[p2++];
        }
        for(int i = 0; i < res.length; i++) {
            nums[i + start] = res[i];
        }
    }
}