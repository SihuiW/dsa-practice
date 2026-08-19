class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];
        for(int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        int k = 0;
        for(int i = 0; i < 3; i++) {
            int times = bucket[i];
            while(times > 0) {
                nums[k] = i;
                k++;
                times--;
            }
        }
    }
}