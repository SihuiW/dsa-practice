class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        int p1 = n - 2;
        while(p1 >= 0 && nums[p1] >= nums[p1 + 1]) {
            p1--;
        }

        if(p1 >= 0) {
            int p2 = n - 1;
            while(nums[p2] <= nums[p1]) {
                p2--;
            }
            int temp = nums[p2];
            nums[p2] = nums[p1];
            nums[p1] = temp;
        }
        
        reverse(nums, p1 + 1, n - 1);
        return;
    }

    void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}