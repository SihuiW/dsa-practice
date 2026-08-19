class Solution {
    public int firstMissingPositive(int[] nums) {
        int missing = 1;
        while(true) {
            boolean flag = true;
           for(int n: nums) {
            if(n == missing) {
                flag = false;
                break;
            }
           }
           if(flag) return missing;
           missing++;
        
        }
    }
}