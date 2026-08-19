class Solution {
    public int majorityElement(int[] nums) {
        int num = 0, count = 0;
        for(int n: nums) {
            if(count == 0) {
                num = n;
            } 
            if(num == n) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}