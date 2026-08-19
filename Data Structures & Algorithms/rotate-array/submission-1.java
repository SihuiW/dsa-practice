class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        f(nums, 0, n - 1);
        f(nums, 0, k - 1);
        f(nums, k, n - 1);
    }

    void f(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}