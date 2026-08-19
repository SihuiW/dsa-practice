class Solution {
    public int largestUniqueNumber(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums[nums.length - 1] + 1];
        for(int n: nums) {
            arr[n]++;
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 1) return i; 
        }
        return -1;
    }
}
